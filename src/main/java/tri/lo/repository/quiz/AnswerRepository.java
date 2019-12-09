package tri.lo.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import tri.lo.model.quiz.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
