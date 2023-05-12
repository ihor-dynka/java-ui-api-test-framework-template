package annotations;

import static config.TestProperties.TESTS_WITH_BREAKING_CHANGES_ENABLED;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.condition.EnabledIf;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@EnabledIf("annotations.Condition#condition")
public @interface TestWithBreakingChanges {
}

class Condition {
    static boolean condition() {
        return TESTS_WITH_BREAKING_CHANGES_ENABLED;
    }
}
