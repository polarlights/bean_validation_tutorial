package io.polarlights.beanvalidation.domain;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Address {

    @NotEmpty
    private String city;
    private String street;
}
