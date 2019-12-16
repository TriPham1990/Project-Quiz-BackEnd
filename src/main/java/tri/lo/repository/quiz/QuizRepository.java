package tri.lo.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import tri.lo.model.quiz.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
