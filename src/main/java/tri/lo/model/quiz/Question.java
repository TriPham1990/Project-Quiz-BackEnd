package tri.lo.model.quiz;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String content;

    @ManyToOne
    @JoinColumn(name = "kindOfQuestion_id")
    private KindOfQuestion kindOfQuestion;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Question() {
    }

    public Question(String content) {
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String question) {
        this.content = question;
    }

    public KindOfQuestion getKindOfQuestion() {
        return kindOfQuestion;
    }

    public void setKindOfQuestion(KindOfQuestion kindOfQuestion) {
        this.kindOfQuestion = kindOfQuestion;
    }

}
