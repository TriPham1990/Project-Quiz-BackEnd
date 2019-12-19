package tri.lo.service.quiz;

import tri.lo.model.quiz.Category;
import tri.lo.model.quiz.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> findAllByCategoryId(Long id);

    List<Question> findAll();

    Optional<Question> findById(Long id);

    void save(Question question);

    void remove(Long id);
}
