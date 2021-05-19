package com.marianowinar.warmup.exception.user;

import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class NullUserException extends UserException{
	public NullUserException() {
        idError = 7;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + ": La cuenta de usuario es nula");
    }

}
