package tri.lo.model.quiz;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "kindOfQuestions")
public class KindOfQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @Min(1)
    @Max(2)
    private int classify;

    public KindOfQuestion() {
    }

    public KindOfQuestion(String name, int classify) {
        this.name = name;
        this.classify = classify;
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

    public void setName(String kindOfQuestions) {
        this.name = kindOfQuestions;
    }

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }
}
