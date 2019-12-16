package tri.lo.service.quiz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tri.lo.model.quiz.Quiz;
import tri.lo.repository.quiz.QuizRepository;
import tri.lo.service.quiz.QuizService;

import java.util.List;
import java.util.Optional;

public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    @Override
    public Optional<Quiz> findById(Long id) {
        return quizRepository.findById(id);
    }

    @Override
    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

    @Override
    public void remove(Long id) {
        quizRepository.deleteById(id);
    }
}
