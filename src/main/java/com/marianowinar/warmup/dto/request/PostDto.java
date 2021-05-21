package com.marianowinar.warmup.dto.request;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

import static com.marianowinar.warmup.model.Category.MAX_CATEGORY_SIZE;
import static com.marianowinar.warmup.model.Category.MIN_CATEGORY_SIZE;
import static com.marianowinar.warmup.model.Post.*;

public class PostDto {

    @NotNull(message = "title cannot be null.")
    @NotBlank(message = "title cannot be empty.")
    @Size(min = MIN_TITLE_SIZE, message = "title must contain at least "
            + MIN_TITLE_SIZE + " characters.")
    @Size(max = MAX_TITLE_SIZE, message = "title must contain less than "
            + MAX_TITLE_SIZE + " characters.")
    private String title;

    @NotNull(message = "content cannot be null.")
    @NotBlank(message = "content cannot be empty.")
    @Size(min = MIN_CONTENT_SIZE, message = "content must contain at least "
            + MIN_CONTENT_SIZE + " characters.")
    @Size(max = MAX_CONTENT_SIZE, message = "content must contain less than "
            + MAX_CONTENT_SIZE + " characters.")
    private String content;

    @URL
    private String image;

    @NotNull(message = "category cannot be null.")
    @NotBlank(message = "category cannot be empty.")
    @Size(min = MIN_CATEGORY_SIZE, message = "category must contain at least "
            + MIN_CATEGORY_SIZE + " characters.")
    @Size(max = MAX_CATEGORY_SIZE, message = "category must contain less than "
            + MAX_CATEGORY_SIZE + " characters.")
    private String nameCategory;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public String getNameCategory() {return nameCategory;}
}
