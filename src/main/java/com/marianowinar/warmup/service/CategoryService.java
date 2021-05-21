package com.marianowinar.warmup.service;

import com.marianowinar.warmup.dto.request.CategoryDto;
import com.marianowinar.warmup.dto.response.CategoryCreationResponseDto;
import com.marianowinar.warmup.dto.response.CategoryResponseDto;
import com.marianowinar.warmup.exception.category.CategoryException;
import com.marianowinar.warmup.exception.category.NullCategoryException;
import com.marianowinar.warmup.mapper.CategoryMapper;
import com.marianowinar.warmup.model.Category;
import com.marianowinar.warmup.repository.CategoryRepository;
import com.marianowinar.warmup.service.interfaces.ICategoryServiceDto;
import com.marianowinar.warmup.util.logger.Errors;
import com.marianowinar.warmup.util.validator.ValidCategory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryServiceDto {

    private CategoryRepository categoryRepository;
    private Errors errors;
    private CategoryMapper mapper;
    private ValidCategory validCategory;

    public CategoryService(CategoryRepository categoryRepository, Errors errors,
                           CategoryMapper categoryMapper, ValidCategory validCategory) {
        this.categoryRepository = categoryRepository;
        this.errors = errors;
        this.mapper = categoryMapper;
        this.validCategory = validCategory;
    }

    @Override
    public CategoryCreationResponseDto save(CategoryDto dto) {
        Category category = mapper.toModel(dto);
        try{
            validCategory.validCreateCategory(category);
            categoryRepository.save(category);
        } catch (CategoryException e) {
            errors.logError(e.getError());
        }

        return mapper.toCategoryCreationDto(category);
    }

    @Override
    public CategoryResponseDto findById(Long id) throws NullCategoryException {
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()) {
            throw new NullCategoryException(category.get().getCategory());
        }

        return mapper.toCategoryDto(category.get());
    }

    @Override
    public CategoryResponseDto findByCategory(String nameCategory) {
        return mapper.toCategoryDto(categoryRepository.findByCategory(nameCategory));
    }

    @Override
    public List<CategoryResponseDto> findAllOrderByCategory() {
        return categoryRepository.getOrderedByCategory().stream().map(u -> mapper.toCategoryDto(u)).collect(Collectors.toList());
    }

    @Override
    public Category categoryFindByCategory(String nameCategory) {
        return categoryRepository.findByCategory(nameCategory);
    }
}
