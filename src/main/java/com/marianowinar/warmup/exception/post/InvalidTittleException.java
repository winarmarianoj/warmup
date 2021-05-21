package com.marianowinar.warmup.exception.post;

import java.time.LocalDateTime;

public class InvalidTittleException extends PostException{
    public InvalidTittleException(String post){
        idError = 12;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + " :" + post + " el título del posteo es invalido.");
    }
}
