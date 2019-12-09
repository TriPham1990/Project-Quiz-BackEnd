package tri.lo.service.quiz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tri.lo.model.quiz.Question;
import tri.lo.repository.quiz.QuestionRepository;
import tri.lo.service.quiz.QuestionService;

import java.util.List;
import java.util.Optional;

public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void remove(Long id) {
        questionRepository.deleteById(id);
    }
}
