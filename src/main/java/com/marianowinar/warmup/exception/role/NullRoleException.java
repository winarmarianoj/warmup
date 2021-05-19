package com.marianowinar.warmup.exception.role;

import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class NullRoleException extends RoleException{
    public NullRoleException(String role){
        idError = 1;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + " :" + role + " el role es nulo.");
    }
}