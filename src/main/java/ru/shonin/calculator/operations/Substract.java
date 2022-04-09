package ru.shonin.calculator.operations;

import org.springframework.stereotype.Component;

@Component
public class Substract implements  Operation{
    @Override
    public double calc(double first, double second) {
        return first - second;
    }
}
