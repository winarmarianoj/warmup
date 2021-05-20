package com.marianowinar.warmup.exception.category;

import java.time.LocalDateTime;

public class NullCategoryException extends CategoryException{
    public NullCategoryException(String category){
        idError = 9;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + " :" + category + " la categoría es nula.");
    }
}
