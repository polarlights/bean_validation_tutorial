package io.polarlights.beanvalidation.advice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorAdvice {

    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMethodBeanValidationException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult().getFieldErrors().stream()
            .map(this::buildMessage)
            .collect(Collectors.toList());
        return errors.toString();
    }

    private String buildMessage(FieldError fe) {
        StringBuilder errorMessage = new StringBuilder("");
        errorMessage.append(fe.getObjectName()).append(".");
        errorMessage.append(fe.getField()).append(": ");
        errorMessage.append(fe.getDefaultMessage());
        return errorMessage.toString();
    }
}
