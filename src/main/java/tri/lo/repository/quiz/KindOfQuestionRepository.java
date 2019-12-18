package tri.lo.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import tri.lo.model.quiz.KindOfQuestion;

public interface KindOfQuestionRepository extends JpaRepository<KindOfQuestion, Long> {
}
