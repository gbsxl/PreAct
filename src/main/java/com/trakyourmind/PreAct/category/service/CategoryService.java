package com.trakyourmind.PreAct.category.service;

import com.trakyourmind.PreAct.category.entity.CategoryEntity;
import com.trakyourmind.PreAct.category.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryEntity> listAllCategories(){
        return repository.findAll();
    }

    public CategoryEntity createCategory(CategoryEntity category){
        return repository.save(category);
    }

    public Optional<CategoryEntity> findCategoryById(Long id){
        return repository.findById(id);
    }

    public void deleteCategoryById(Long id){
        repository.deleteById(id);
    }

}
