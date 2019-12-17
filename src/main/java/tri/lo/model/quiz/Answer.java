package tri.lo.model.quiz;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private boolean correct;

    @NotBlank
    private String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "questions")
    private Question question;

    public Answer() {
    }

    public Answer(boolean correct, String name) {
        this.correct = correct;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getName() {
        return name;
    }

    public void setName(String answer) {
        this.name = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}