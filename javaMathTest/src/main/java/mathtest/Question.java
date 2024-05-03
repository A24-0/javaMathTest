package mathtest;

import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    public int getId() {
        return id;
    }

    private String content;
    private String answer;
    public Question() {
        int a = ThreadLocalRandom.current().nextInt(1, 9 + 1);
        int b = ThreadLocalRandom.current().nextInt(1, 9 + 1);
        int operator = ThreadLocalRandom.current().nextInt(1, 4 + 1);

        String operation;
        int result;

        switch(operator) {
            case 1:
                operation = "+";
                result = a + b;
                break;
            case 2:
                operation = "-";
                result = a - b;
                break;
            case 3:
                operation = "*";
                result = a * b;
                break;
            case 4:
                operation = "*";
                result = a * b;
                if (result != 0) {
                    operation = "/";
                    a = result;
                    result = a / b;
                }
                else
                    result = a / 1;
                break;
            default:
                operation = "+";
                result = a + b;
        }
        this.content = a + operation + b + " = ";
        this.answer = Integer.toString(result);
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}