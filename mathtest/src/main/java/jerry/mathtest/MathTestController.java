package jerry.mathtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MathTestController {

    private Question question;

    @Autowired
    public void setQuestion(Question question) {
        this.question = question;
    }

    @GetMapping("/question")
    public Question showQuestion(){
        question = new Question();
        return question;
    }

    @GetMapping("/next")
    public Question tryNext(){
        question = new Question();
        return question;
    }

    @PostMapping("/answer")
    public Result checkAnswer(@RequestBody String answerString){
        int operand1 = question.getOperand1();
        int operand2 = question.getOperand2();
        String operator = question.getOperator();
        int answer;
        try {
            answer = Integer.parseInt(answerString);
        }catch (NumberFormatException e){
            return new Result("wrongFormat") ;
        }

        switch (operator){
            case "+":
                if (answer == operand1 + operand2)
                    return new Result("correct");
            case "-":
                if (answer == operand1 - operand2)
                    return new Result("correct");
            case "*":
                if (answer == operand1 * operand2)
                    return new Result("correct");
            case "/":
                if (answer == operand1 / operand2)
                    return new Result("correct");
        }
        return new Result("incorrect");
    }

}
