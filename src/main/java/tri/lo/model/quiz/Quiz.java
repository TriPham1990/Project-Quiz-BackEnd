package tri.lo.model.quiz;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "quizzes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @NotBlank
    private int questionCount;

    public Quiz() {
    }

    public Quiz(String name, int questionCount) {
        this.name = name;
        this.questionCount = questionCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameQuiz) {
        this.name = nameQuiz;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
}
