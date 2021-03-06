package tri.lo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tri.lo.model.quiz.Answer;
import tri.lo.service.quiz.AnswerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping
    private ResponseEntity<List<Answer>> listAllAnswer() {
        List<Answer> answers = answerService.findAll();
        if (answers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> createAnswer(@RequestBody Answer answer) {
        answerService.save(answer);
        return new ResponseEntity<>(answer, HttpStatus.CREATED);
    }

    @GetMapping(value = "/findByQuestion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Answer>> getAllQuestionByCategoryId(@PathVariable Long id) {
        List<Answer> answers = answerService.findAllByQuestionId(id);
        if (answers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
        Optional<Answer> answer = answerService.findById(id);
        if (answer.isPresent()) {
            return new ResponseEntity<>(answer.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id")
    private ResponseEntity<Answer> deleteAnswer(@PathVariable Long id) {
        Optional<Answer> answer = answerService.findById(id);
        if (answer.isPresent()) {
            answerService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
