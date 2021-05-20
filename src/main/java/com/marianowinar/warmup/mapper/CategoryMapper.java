package com.marianowinar.warmup.mapper;

import com.marianowinar.warmup.dto.request.CategoryDto;
import com.marianowinar.warmup.dto.response.CategoryCreationResponseDto;
import com.marianowinar.warmup.dto.response.CategoryResponseDto;
import com.marianowinar.warmup.model.Category;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class CategoryMapper {

    public Category toModel(CategoryDto dto){
        Category category = new Category();
        category.setCategory(dto.getCategory());
        return category;
    }

    public CategoryCreationResponseDto toCategoryCreationDto(Category category) {
        CategoryCreationResponseDto dto = new CategoryCreationResponseDto();
        dto.setId(category.getCategoryId());
        dto.setUri(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/category/{id}")
                .buildAndExpand(dto.getId()).toUri());

        return dto;
    }

    public CategoryResponseDto toCategoryDto(Category category) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setCategory(category.getCategory());
        return dto;
    }
}
