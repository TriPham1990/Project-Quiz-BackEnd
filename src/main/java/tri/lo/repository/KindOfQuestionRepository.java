package tri.lo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tri.lo.model.KindOfQuestion;

public interface KindOfQuestionRepository extends JpaRepository<KindOfQuestion, Long> {
}
