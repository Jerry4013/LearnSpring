package jerry.mathtest;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Random;

@Repository
public class Question {

    Random random = new Random();
    private int operand1;
    private int operand2;
    private String operator;

    public Question() {
        this.onInit();
    }

    @PostConstruct
    public void onInit() {
        operator = randomOperator();
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
    }

    public String getOperator() {
        return operator;
    }

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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
