package aspects;

import annotations.APIStep;
import annotations.UIStep;
import logger.ILogger;
import logger.TestLogger;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import reporter.AllureReporter;
import reporter.IReporter;
import reporter.StepStatus;

import java.lang.reflect.Method;
import java.util.UUID;

@Aspect
public class LogAspect {

    private String uuid;

    private static final ILogger LOGGER = new TestLogger();

    private static final IReporter ALLURE_REPORTER = new AllureReporter();

    @Pointcut("@annotation(annotations.APIStep)")
    private void apiStep() {
    }

    @Pointcut("@annotation(annotations.UIStep)")
    private void uiStep() {
    }

    @SneakyThrows
    @Before("apiStep() || uiStep()")
    public void logBeforeSteps(JoinPoint joinPoint) {
        Method method = getMethod(joinPoint);
        uuid = getUuid();

        LOGGER.info("Step started: " + getStepName(method));
        ALLURE_REPORTER.startStep(getStepName(method));
    }

    @AfterThrowing(pointcut = "apiStep() || uiStep()", throwing = "exception")
    public void logFailedStep(JoinPoint joinPoint, Throwable exception) {
        Method method = getMethod(joinPoint);
        LOGGER.error("Step finished: " + getStepName(method), exception);
        ALLURE_REPORTER.endStep(uuid, StepStatus.FAILED);
    }

    @AfterReturning(pointcut = "apiStep() || uiStep()")
    public void logAfterStep(JoinPoint joinPoint) {
        Method method = getMethod(joinPoint);
        LOGGER.info("Step finished: " + getStepName(method));
        ALLURE_REPORTER.endStep(splitCamelCase(method.getName()), StepStatus.PASSED);
    }

    private String getUuid() {
        return UUID.randomUUID().toString();
    }

    private Method getMethod(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        return methodSignature.getMethod();
    }

    private String splitCamelCase(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }

    private String getStepName(Method method) {
        APIStep apiAnnotation = method.getAnnotation(APIStep.class);
        UIStep uiAnnotation = method.getAnnotation(UIStep.class);

        if ((apiAnnotation != null && apiAnnotation.value().isEmpty()) || (uiAnnotation != null && uiAnnotation.value().isEmpty())) {
            return method.getDeclaringClass() + " " + splitCamelCase(method.getName());
        } else {
            return method.getDeclaringClass() + " " + apiAnnotation.value();
        }
    }
}
