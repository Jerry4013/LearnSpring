package jerry.mathtest;

import org.springframework.stereotype.Repository;

//@Repository
public class Question {

    private int operand1;
    private int operand2;
    private String operator;
    private int answer;
    private String result;

    public Question(int operand1, int operand2, String operator) {
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
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

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
