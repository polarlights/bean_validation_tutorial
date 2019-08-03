package polarlights.io.bean.validation.raw;

import java.util.ArrayList;
import java.util.List;

public class UserValidationService {

    public static void validateInstantError(User user) {
        if (user.getName() == null) {
            throw new ConstrainsValidationException("name can not be null");
        }

        if (user.getAge() < 0) {
            throw new ConstrainsValidationException("age can not less than 0");
        }
    }

    public static void validateAllErrors(User user) {
        List<String> errorMessages = new ArrayList<>();
        if (user.getName() == null) {
            errorMessages.add("name can not be null");
        }

        if (user.getAge() < 0) {
            errorMessages.add("age can not less than 0");
        }

        if (errorMessages.size() > 0) {
            throw new ConstrainsValidationException(errorMessages);
        }
    }
}
