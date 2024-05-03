package mathtest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MathResult {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;

    public MathResult() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

	@ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private String response;
    public String getResponse() {
        return response;
    }
    public void setResponse(String response) {
        this.response = response;
    }

    public MathResult(Question q, String answer) {
        question = q;
        response = answer;
    }
}
