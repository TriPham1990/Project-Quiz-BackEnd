package tri.lo.model.quiz;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @NotBlank
    private String name;

    @OneToMany//(targetEntity = Answer.class, mappedBy = "question")
    @JoinColumn(name = "answers_id")
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "kindOfQuestions_id")
    private KindOfQuestion kindOfQuestions;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Category category;

    public Question() {
    }

    public Question(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String question) {
        this.name = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public KindOfQuestion getKindOfQuestions() {
        return kindOfQuestions;
    }

    public void setKindOfQuestions(KindOfQuestion kindOfQuestions) {
        this.kindOfQuestions = kindOfQuestions;
    }
}
