package io.polarlights.beanvalidation.controller;

import java.util.Locale;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.polarlights.beanvalidation.domain.Address;
import io.polarlights.beanvalidation.domain.CreateUserRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void createUser() throws Exception {
        CreateUserRequest userRequest = new CreateUserRequest()
            .setAge(-1)
            .setName(null)
            .setAddress(new Address());

        MvcResult mvcResult = mockMvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .locale(Locale.SIMPLIFIED_CHINESE)
            .content(objectMapper.writeValueAsString(userRequest)))
            .andExpect(status().isBadRequest())
            .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}