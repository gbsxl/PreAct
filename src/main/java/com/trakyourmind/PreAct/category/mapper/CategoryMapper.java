package com.trakyourmind.PreAct.category.mapper;

import com.trakyourmind.PreAct.category.controller.request.CategoryRequest;
import com.trakyourmind.PreAct.category.controller.response.CategoryResponse;
import com.trakyourmind.PreAct.category.entity.CategoryEntity;
import lombok.experimental.UtilityClass;

@UtilityClass

public class CategoryMapper {
    public static CategoryEntity toCategory (CategoryRequest request){
        return CategoryEntity
                .builder()
                .area(request.area())
                .build();
    }

    public static CategoryResponse toResponse (CategoryEntity category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .area(category.getArea())
                .build();
    }
    }
