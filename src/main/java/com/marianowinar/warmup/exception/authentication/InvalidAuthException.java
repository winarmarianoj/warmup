package com.marianowinar.warmup.exception.authentication;

import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class InvalidAuthException extends AuthException{
    public InvalidAuthException() {
        idError = 8;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + ": Incorrect username or password");
    }
}
