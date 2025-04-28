package com.trakyourmind.PreAct.category.controller;

import com.trakyourmind.PreAct.category.controller.request.CategoryRequest;
import com.trakyourmind.PreAct.category.controller.response.CategoryResponse;
import com.trakyourmind.PreAct.category.entity.Category;
import com.trakyourmind.PreAct.category.mapper.CategoryMapper;
import com.trakyourmind.PreAct.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("preact/category")
@RequiredArgsConstructor
public class CategoryController {
    CategoryService service;
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<CategoryResponse>> listAllCategories(){
        return ResponseEntity.ok(service.listAllCategories().stream()
                .map(CategoryMapper::toResponse)
                .toList());
    }

    @PostMapping("/create")
    ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest request){
        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = service.createCategory(newCategory);
       return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toResponse(savedCategory));
    }

    @GetMapping("/{id}")
    ResponseEntity<CategoryResponse> findCategoryById(@PathVariable Long id){
        return service.findCategoryById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCategoryById(@PathVariable Long id){
        service.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
