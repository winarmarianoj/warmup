package com.marianowinar.warmup.exception.category;

import java.time.LocalDateTime;


public class InvalidCategoryException extends CategoryException{
    public InvalidCategoryException(String category){
        idError = 8;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + " :" + category + " " + " no es una Categoría valido.");
    }
}
