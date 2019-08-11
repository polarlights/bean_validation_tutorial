package io.polarlights.bean.validation.raw;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RawValidationExampleTest {

    private User user;

    @BeforeEach
    void init() {
        user = new User();
        user.setAge(-1);
        user.setName(null);
    }

    @Test
    void instantValidationError() {
        try {
            UserValidationService.validateInstantError(user);
        } catch (ConstrainsValidationException e) {
            Set<String> errorMessages = e.getErrorMessages();
            assertThat(errorMessages).hasSize(1);
            assertThat(errorMessages.iterator().next()).isEqualTo("name can not be null");
        }
    }

    @Test
    void raiseValidationExceptionBatch() {
        try {
            UserValidationService.validateAllErrors(user);
        } catch (ConstrainsValidationException e) {
            Set<String> errorMessages = e.getErrorMessages();
            assertThat(errorMessages).hasSize(2)
                .contains("name can not be null")
                .contains("age can not less than 0");
        }
    }
}
