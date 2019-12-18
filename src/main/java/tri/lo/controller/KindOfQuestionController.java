package tri.lo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tri.lo.model.quiz.Category;
import tri.lo.model.quiz.KindOfQuestion;
import tri.lo.service.quiz.KindOfQuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/auth/kindOfQuestions")
public class KindOfQuestionController {

    @Autowired
    private KindOfQuestionService kindOfQuestionService;

    @GetMapping
    private ResponseEntity<List<KindOfQuestion>> getAllListKindOfQuestions() {
        List<KindOfQuestion> kindOfQuestions = kindOfQuestionService.findAll();
        if (kindOfQuestions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(kindOfQuestions, HttpStatus.OK);
    }
}
