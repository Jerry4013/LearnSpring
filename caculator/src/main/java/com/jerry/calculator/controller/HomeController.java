package com.jerry.calculator.controller;

import com.jerry.calculator.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/")
    public String calculator(Model model) {
        Calculator calculator = new Calculator();
        calculator.setOperand1(1);
        calculator.setOperand2(1);
        calculator.setOperator("+");
        calculator.setResult(2);
        model.addAttribute("calculator", calculator);
        return "calculator";
    }

    @PostMapping("/calculator")
    public String post(@ModelAttribute("calculator") Calculator calculator) {
        double op1 = calculator.getOperand1();
        double op2 = calculator.getOperand2();
        double result = 0;
        if (calculator.getOperator().equals("+")) {
            result = op1 + op2;
        } else if (calculator.getOperator().equals("-")){
            result = op1 - op2;
        } else if (calculator.getOperator().equals("*")){
            result = op1 * op2;
        } else if (calculator.getOperator().equals("/")){
            result = op1 / op2;
        }
        calculator.setResult(result);
        return "calculator";
    }
}
