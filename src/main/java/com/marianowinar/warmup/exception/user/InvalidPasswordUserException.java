package com.marianowinar.warmup.exception.user;

import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class InvalidPasswordUserException extends UserException{
	public InvalidPasswordUserException(String password) {
        idError = 6;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + " :" + password + ": El Password del usuario es nulo");
    }

}
