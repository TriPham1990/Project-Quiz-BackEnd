package tri.lo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tri.lo.model.quiz.Question;
import tri.lo.service.quiz.QuestionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    private ResponseEntity<List<Question>> listAllQuestion() {
        List<Question> questions = questionService.findAll();

        if (questions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> createQuestion(@RequestBody Question question) {
        questionService.save(question);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Optional<Question> question = questionService.findById(id);
        if (question.isPresent()) {
            return new ResponseEntity<>(question.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        Optional<Question> currentQuestion = questionService.findById(id);
        if (currentQuestion.isPresent()) {
            currentQuestion.get().setId(question.getId());
            currentQuestion.get().setContent(question.getContent());
            currentQuestion.get().setCategory(question.getCategory());

            questionService.save(currentQuestion.get());
            return new ResponseEntity<>(currentQuestion.get(), HttpStatus.OK);
        }

        return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Question> deleteQuestion(@PathVariable Long id) {
        Optional<Question> question = questionService.findById(id);
        if (question.isPresent()) {
            questionService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
