package ru.shonin.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestNumberFormatException extends RuntimeException{
    public RequestNumberFormatException(String parameter) {
        super("the parameter " + parameter + " is not a number");
    }
}
