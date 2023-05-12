package annotations;

import io.qameta.allure.LinkAnnotation;
import io.qameta.allure.util.ResultsUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@LinkAnnotation(type = ResultsUtils.TMS_LINK_TYPE)
public @interface UIStep {
    String value() default "";
}
