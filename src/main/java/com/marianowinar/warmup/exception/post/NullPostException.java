package com.marianowinar.warmup.exception.post;

import java.time.LocalDateTime;

public class NullPostException extends PostException{
    public NullPostException(String post){
        idError = 10;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + " :" + post + " el posteo es nulo.");
    }
}
