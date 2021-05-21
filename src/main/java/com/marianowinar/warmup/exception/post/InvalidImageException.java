package com.marianowinar.warmup.exception.post;

import java.time.LocalDateTime;

public class InvalidImageException extends PostException{
    public InvalidImageException(String post){
        idError = 14;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + " :" + post + " la imagen del posteo es invalido.");
    }
}
