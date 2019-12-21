package tri.lo.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import tri.lo.model.quiz.Answer;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findAllByQuestionId(Long id);
}
