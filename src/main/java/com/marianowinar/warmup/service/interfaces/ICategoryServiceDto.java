package com.marianowinar.warmup.service.interfaces;

import com.marianowinar.warmup.dto.request.CategoryDto;
import com.marianowinar.warmup.dto.response.CategoryCreationResponseDto;
import com.marianowinar.warmup.dto.response.CategoryResponseDto;
import com.marianowinar.warmup.exception.category.NullCategoryException;
import com.marianowinar.warmup.model.Category;

import java.util.List;

public interface ICategoryServiceDto {

    CategoryCreationResponseDto save(CategoryDto dto);

    CategoryResponseDto findById(Long id) throws NullCategoryException;

    CategoryResponseDto findByCategory(String category);

    List<CategoryResponseDto> findAllOrderByCategory();

    Category categoryFindByCategory(String nameCategory);
}
