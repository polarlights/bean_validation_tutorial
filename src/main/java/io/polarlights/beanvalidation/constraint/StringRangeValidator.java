package io.polarlights.beanvalidation.constraint;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringRangeValidator implements ConstraintValidator<StringRange, String> {

    Set<String> valueSets = new HashSet<>();

    @Override
    public void initialize(StringRange constraintAnnotation) {
        for (String str : constraintAnnotation.values()) {
            if (Objects.nonNull(str)) {
                valueSets.add(str);
            }
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return valueSets.contains(value);
    }
}
