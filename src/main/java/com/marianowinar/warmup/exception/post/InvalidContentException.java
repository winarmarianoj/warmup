package com.marianowinar.warmup.exception.post;

import java.time.LocalDateTime;

public class InvalidContentException extends PostException{
    public InvalidContentException(String post){
        idError = 13;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + " :" + post + " el contenido del posteo es invalido.");
    }
}
