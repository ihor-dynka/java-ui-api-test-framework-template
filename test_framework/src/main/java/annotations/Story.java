package annotations;

import io.qameta.allure.LinkAnnotation;
import io.qameta.allure.util.ResultsUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@LinkAnnotation(type = ResultsUtils.FEATURE_LABEL_NAME)
public @interface Story {

	String value();
}
