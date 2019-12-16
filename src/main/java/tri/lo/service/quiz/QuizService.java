package tri.lo.service.quiz;

import tri.lo.model.quiz.Question;
import tri.lo.model.quiz.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {

    List<Quiz> findAll();

    Optional<Quiz> findById(Long id);

    void save(Quiz quiz);

    void remove(Long id);
}
