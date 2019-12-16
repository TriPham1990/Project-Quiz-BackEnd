package tri.lo.model.quiz;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "kindOfQuestions")
public class KindOfQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String kindOfQuestions;

    @Min(1)
    @Max(2)
    private int classify;

    public KindOfQuestion() {
    }

    public KindOfQuestion(String kindOfQuestions, int classify) {
        this.kindOfQuestions = kindOfQuestions;
        this.classify = classify;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKindOfQuestions() {
        return kindOfQuestions;
    }

    public void setKindOfQuestions(String kindOfQuestions) {
        this.kindOfQuestions = kindOfQuestions;
    }

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }
}
