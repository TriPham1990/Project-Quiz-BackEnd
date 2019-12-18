package tri.lo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tri.lo.model.quiz.Answer;
import tri.lo.model.quiz.Category;
import tri.lo.model.quiz.Question;
import tri.lo.service.quiz.AnswerService;
import tri.lo.service.quiz.CategoryService;
import tri.lo.service.quiz.QuestionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @GetMapping
    private ResponseEntity<List<Category>> listAllCategories() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Void> createCategory(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
        categoryService.save(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/auth/kindOfQuestions/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            return new ResponseEntity<>(category.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    private ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> currentCategory = categoryService.findById(id);
        if (currentCategory.isPresent()) {
            currentCategory.get().setName(category.getName());
            currentCategory.get().setId(category.getId());

            categoryService.save(currentCategory.get());

            return new ResponseEntity<Category>(currentCategory.get(), HttpStatus.OK);
        }

        return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Category> deleteCategory(@PathVariable Long id) {

        Optional<Category> category = categoryService.findById(id);

        if (category.isPresent()) {
            categoryService.remove(id);
            return new ResponseEntity<Category>(HttpStatus.OK);
        }


        return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);

    }
}
