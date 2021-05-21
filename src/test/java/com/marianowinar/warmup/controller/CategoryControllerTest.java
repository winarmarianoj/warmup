package com.marianowinar.warmup.controller;

import com.marianowinar.warmup.dto.request.CategoryDto;
import com.marianowinar.warmup.dto.response.CategoryCreationResponseDto;
import com.marianowinar.warmup.dto.response.CategoryResponseDto;
import com.marianowinar.warmup.exception.category.NullCategoryException;
import com.marianowinar.warmup.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CategoryControllerTest {

    private CategoryController controller;

    @BeforeEach
    void setUp() throws NullCategoryException {
        CategoryService service = mock(CategoryService.class);
        when(service.findById(1L)).thenReturn(new CategoryResponseDto());
        controller = new CategoryController(service);
    }

    /**
     * Devuelve todos los datos de una categoría según su Id
     * @throws NullCategoryException
     */
    @Test
    void getCategory() throws NullCategoryException {
        Long num = Long.valueOf(1);
        CategoryService service = mock(CategoryService.class);
        when(service.findById(num)).thenReturn(new CategoryResponseDto());
    }

    /**
     * Devuelve una categoría con todos su datos según su nombre
     */
    @Test
    void getCategoryName() {
        String names = "Category";
        CategoryService service = mock(CategoryService.class);
        when(service.findByCategory(names)).thenReturn(new CategoryResponseDto());
    }

    /**
     * Crea una Categoría nueva en la BD
     */
    @Test
    void postCategory() {
        CategoryDto dto = mock(CategoryDto.class);
        CategoryService service = mock(CategoryService.class);
        when(service.save(dto)).thenReturn(new CategoryCreationResponseDto());
    }
}