package com.trakyourmind.PreAct.category.mapper;

import com.trakyourmind.PreAct.category.controller.request.CategoryRequest;
import com.trakyourmind.PreAct.category.controller.response.CategoryResponse;
import com.trakyourmind.PreAct.category.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass

public class CategoryMapper {
    public static Category toCategory (CategoryRequest request){
        return Category
                .builder()
                .area(request.area())
                .build();
    }

    public static CategoryResponse toResponse (Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .area(category.getArea())
                .build();
    }
    }
