package polarlights.io.bean.validation.raw;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class ConstrainsValidationException extends RuntimeException {

    private static final long serialVersionUID = 5705896384404863964L;

    private Set<String> errorMessages = new HashSet<>();

    public ConstrainsValidationException(String message) {
        errorMessages.add(message);
    }

    public ConstrainsValidationException(Collection<String> errorMessages) {
        this.errorMessages.addAll(errorMessages);
    }
}
