package ru.shonin.calculator.operations;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Sum implements Operation{
    @Override
    public double calc(double first, double second) {
        return first + second;
    }
}
