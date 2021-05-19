package com.marianowinar.warmup.dto.request;

import javax.validation.constraints.*;

import static com.marianowinar.warmup.model.Category.*;

public class CategoryDto {

    @NotNull(message = "category cannot be null.")
    @NotBlank(message = "category cannot be empty.")
    @Size(min = MIN_CATEGORY_SIZE, message = "category must contain at least "
            + MIN_CATEGORY_SIZE + " characters.")
    @Size(max = MAX_CATEGORY_SIZE, message = "category must contain less than "
            + MAX_CATEGORY_SIZE + " characters.")
    private String category;

    public String getCategory() {
        return category;
    }
}
