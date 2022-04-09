package ru.shonin.calculator.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.shonin.calculator.exception.DivisionByZeroException;
import ru.shonin.calculator.exception.RequestNumberFormatException;
import ru.shonin.calculator.operations.Divide;
import ru.shonin.calculator.operations.Multiply;
import ru.shonin.calculator.operations.Substract;
import ru.shonin.calculator.operations.Sum;

@RestController
@RequestMapping("/calc")
public class CalcController {

    @Autowired
    ApplicationContext context;

    @GetMapping("/add")
    public String add(@RequestParam String first, @RequestParam String second){
        double firstD = parse(first);
        double secondD = parse(second);
        return String.valueOf(context.getBean(Sum.class).calc(firstD,secondD));
    }

    @GetMapping("/substract")
    public String substract(@RequestParam String first, @RequestParam String second){
        double firstD = parse(first);
        double secondD = parse(second);
        return String.valueOf(context.getBean(Substract.class).calc(firstD,secondD));
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam String first, @RequestParam String second){
        double firstD = parse(first);
        double secondD = parse(second);
        return String.valueOf(context.getBean(Multiply.class).calc(firstD,secondD));
    }

    @GetMapping("/divide")
    public String divide(@RequestParam String first, @RequestParam String second){
        double firstD = parse(first);
        double secondD = parse(second);
        if (secondD == 0){
            throw new DivisionByZeroException();
        }
        return String.valueOf(context.getBean(Divide.class).calc(firstD,secondD));
    }

    double parse(String parseNumber){
        double number;
        try {
            number = Double.parseDouble(parseNumber);

        }
        catch (NumberFormatException e){
            throw new RequestNumberFormatException(parseNumber);
        }

        return number;
    }
}
