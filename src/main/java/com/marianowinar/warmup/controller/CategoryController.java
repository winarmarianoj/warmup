package com.marianowinar.warmup.controller;

import com.marianowinar.warmup.dto.request.CategoryDto;
import com.marianowinar.warmup.dto.response.CategoryCreationResponseDto;
import com.marianowinar.warmup.dto.response.CategoryResponseDto;
import com.marianowinar.warmup.exception.category.NullCategoryException;
import com.marianowinar.warmup.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable("id") Long id) throws NullCategoryException {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @ResponseBody
    @GetMapping("/category/{category}")
    public ResponseEntity<CategoryResponseDto> getCategoryName(@PathVariable("category") String category) {
        return ResponseEntity.ok(categoryService.findByCategory(category));
    }

    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<List<CategoryResponseDto>> getCategory() {
        return ResponseEntity.ok(categoryService.findAllOrderByCategory());
    }

    @ResponseBody
    @PostMapping("/save")
    public ResponseEntity<CategoryCreationResponseDto> postCategory(
            @RequestBody @Valid CategoryDto request) {
        CategoryCreationResponseDto response = categoryService.save(request);

        return ResponseEntity.created(response.getUri())
                .body(response);
    }
}
