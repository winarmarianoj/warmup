package com.marianowinar.warmup.exception.user;

import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class InvalidEmailException extends UserException{
	public InvalidEmailException(String email){
        idError = 5;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + " :" + email + " en el usuario no es un tipo de Email valido.");
    }
}
