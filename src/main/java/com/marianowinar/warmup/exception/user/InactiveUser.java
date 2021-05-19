package com.marianowinar.warmup.exception.user;

import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class InactiveUser extends UserException{
    public InactiveUser() {
        idError = 4;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + ": La cuenta de usuario no esta activa");
    }

}
