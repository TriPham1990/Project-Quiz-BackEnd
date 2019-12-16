package tri.lo.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import tri.lo.model.quiz.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
