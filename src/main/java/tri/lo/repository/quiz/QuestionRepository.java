package tri.lo.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import tri.lo.model.quiz.Category;
import tri.lo.model.quiz.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByCategoryId(Long id);
}
