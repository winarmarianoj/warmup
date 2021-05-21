package com.marianowinar.warmup.util.validator;

import com.marianowinar.warmup.exception.post.*;
import com.marianowinar.warmup.model.Post;
import org.springframework.stereotype.Component;

@Component
public class ValidPost extends Validator{

    public void validCreatePost(Post post) throws PostException {
        if(post == null)
            throw new NullPostException(post.getTitle());

        validTitle(post.getTitle());
        validContent(post.getContent());
        validImage(post.getImage());
        validDate(post.getDate().toString());
    }

    public void validDate(String date) throws InvalidDateException {
        if(date == null)
            throw new InvalidDateException(date + "is null");
    }

    public void validImage(String image) throws InvalidImageException {
        if(image == null)
            throw new InvalidImageException(image + "is null");
    }

    public void validContent(String content) throws InvalidContentException {
        if(content == null)
            throw new InvalidContentException(content + "is null");
    }

    public void validTitle(String title) throws InvalidTittleException {
        if(title == null)
            throw new InvalidTittleException(title + "is null");
    }
}
