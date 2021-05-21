package com.marianowinar.warmup.exception.post;

import java.time.LocalDateTime;

public class InvalidPostException extends PostException{
    public InvalidPostException(String post){
        idError = 11;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + " :" + post + " el posteo es invalido.");
    }
}
