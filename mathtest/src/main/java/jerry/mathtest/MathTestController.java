package jerry.mathtest;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping
public class MathTestController {

    Random random = new Random();

//    private Question question;

//    public MathTestController(Question question) {
//        this.question = question;
//    }

    @GetMapping("/question")
    public Question showQuestion(){
        String operator = randomOperator();
        int operand1, operand2;
        if (operator.equals("*")){
            operand1 = random.nextInt(15) + 1;
            operand2 = random.nextInt(15) + 1;
        } else if (operator.equals("/")){
            operand2 = random.nextInt(10) + 1;
            operand1 = operand2 * (random.nextInt(10) + 1);
        } else {
            operand1 = random.nextInt(100) + 1;
            operand2 = random.nextInt(100) + 1;
        }
        return new Question(operand1, operand2, operator);
    }

    @PostMapping("/answer")
    public Question checkAnswer(@RequestBody Question question){
        int operand1 = question.getOperand1();
        int operand2 = question.getOperand2();
        String operator = question.getOperator();
        int answer = question.getAnswer();
        question.setResult("incorrect");
        switch (operator){
            case "+":
                if (answer == operand1 + operand2)
                    question.setResult("correct");
                break;
            case "-":
                if (answer == operand1 - operand2)
                    question.setResult("correct");
                break;
            case "*":
                if (answer == operand1 * operand2)
                    question.setResult("correct");
                break;
            case "/":
                if (answer == operand1 / operand2)
                    question.setResult("correct");
                break;
        }
        return question;
    }

    private String randomOperator(){
        String result = null;
        switch (random.nextInt(4)){
            case 0:
                result = "+";
                break;
            case 1:
                result = "-";
                break;
            case 2:
                result = "*";
                break;
            case 3:
                result = "/";
                break;
        }
        return result;
    }
}
