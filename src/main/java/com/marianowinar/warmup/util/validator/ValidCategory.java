package com.marianowinar.warmup.util.validator;

import com.marianowinar.warmup.exception.category.CategoryException;
import com.marianowinar.warmup.exception.category.InvalidCategoryException;
import com.marianowinar.warmup.exception.category.NullCategoryException;
import com.marianowinar.warmup.model.Category;
import org.springframework.stereotype.Component;

@Component
public class ValidCategory extends Validator{

    public void validCreateCategory(Category category) throws CategoryException {
        if(category == null)
            throw new NullCategoryException(category.getCategory());

        validCategory(category.getCategory());
    }

    public void validCategory(String category) throws InvalidCategoryException {
        if(category == null)
            throw new InvalidCategoryException(category + "is null");
    }

}
