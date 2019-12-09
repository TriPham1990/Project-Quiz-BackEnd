package tri.lo.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import tri.lo.model.quiz.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
