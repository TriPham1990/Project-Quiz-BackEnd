package tri.lo.service.quiz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tri.lo.model.quiz.Category;
import tri.lo.repository.quiz.CategoryRepository;
import tri.lo.service.quiz.CategoryService;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
