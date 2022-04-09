package ru.shonin.calculator.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DivisionByZeroException extends RuntimeException{
    public DivisionByZeroException() {
        super("Division by 0 is not possible");
    }
}
