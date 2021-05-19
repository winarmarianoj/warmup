package com.marianowinar.warmup.exception.user;

import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class ExistingUserException extends UserException{
	
	public ExistingUserException(String text) {
        idError = 3;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error "+ idError +": Ya existe una cuenta de usuario vinculada a " + text);
    }

}
