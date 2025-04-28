package com.trakyourmind.PreAct.category.service;

import com.trakyourmind.PreAct.category.entity.Category;
import com.trakyourmind.PreAct.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> listAllCategories(){
        return repository.findAll();
    }

    public Category createCategory(Category category){
        return repository.save(category);
    }

    public Optional<Category> findCategoryById(Long id){
        return repository.findById(id);
    }

    public void deleteCategoryById(Long id){
        repository.deleteById(id);
    }

}
