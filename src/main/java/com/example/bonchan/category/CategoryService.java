package com.example.bonchan.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<Category> GetCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Iterable<Category> GetAllCategories() {
        return categoryRepository.findAll();
    }

    public Category CreateCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void DeleteCategory(Long id) {
        var category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        categoryRepository.deleteById(id);
    }

    public Category UpdateCategory(Category category) {
        var cat = categoryRepository.findById(category.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return categoryRepository.save(category);
    }

}

