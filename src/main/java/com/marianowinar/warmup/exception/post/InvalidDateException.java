package com.marianowinar.warmup.exception.post;

import java.time.LocalDateTime;

public class InvalidDateException extends PostException{
    public InvalidDateException(String post){
        idError = 15;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + " :" + post + " la fecha del posteo es invalido.");
    }
}
