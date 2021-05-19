package com.marianowinar.warmup.dto.request;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

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
    //@Pattern(regexp="(.)+\\.(jpg|png|jpeg)$", message="Please provide a valid email address")
    private String image;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }
}
