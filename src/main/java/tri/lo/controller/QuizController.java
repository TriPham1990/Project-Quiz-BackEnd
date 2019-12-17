package tri.lo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tri.lo.model.quiz.Quiz;
import tri.lo.service.quiz.QuizService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/auth/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    private ResponseEntity<List<Quiz>> listAllQuizzes() {
        List<Quiz> quizzes = quizService.findAll();

        if (quizzes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Void> createQuiz(@RequestBody Quiz quiz, UriComponentsBuilder ucBuilder) {
        quizService.save(quiz);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/auth/questions/{id}").buildAndExpand(quiz.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        Optional<Quiz> quiz = quizService.findById(id);
        if (quiz.isPresent()) {
            return new ResponseEntity<>(quiz.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Quiz> updateQuestion(@PathVariable Long id, @RequestBody Quiz quiz) {
        Optional<Quiz> currentQuiz = quizService.findById(id);
        if (currentQuiz.isPresent()) {
            currentQuiz.get().setId(quiz.getId());
            currentQuiz.get().setName(quiz.getName());
            currentQuiz.get().setQuestions(quiz.getQuestions());

            quizService.save(currentQuiz.get());
            return new ResponseEntity<>(currentQuiz.get(), HttpStatus.OK);
        }

        return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Quiz> deleteQuestion(@PathVariable Long id) {
        Optional<Quiz> quiz = quizService.findById(id);
        if (quiz.isPresent()) {
            quizService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
