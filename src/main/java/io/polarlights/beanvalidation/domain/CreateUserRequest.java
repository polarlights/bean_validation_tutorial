package io.polarlights.beanvalidation.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

@Data
@Accessors(chain = true)
public class CreateUserRequest {

    @NotEmpty
    private String name;
    @Range(min = 1, max = 125)
    private Integer age;
    @Valid
    @NotNull
    private Address address;
}
