package io.polarlights.beanvalidation.controller;

import javax.validation.Valid;

import io.polarlights.beanvalidation.domain.CreateUserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/users")
    public void createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
    }
}

