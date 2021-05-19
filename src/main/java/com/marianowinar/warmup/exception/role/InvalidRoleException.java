package com.marianowinar.warmup.exception.role;

import java.time.LocalDateTime;

import com.marianowinar.warmup.model.enums.RoleName;

@SuppressWarnings("serial")
public class InvalidRoleException extends RoleException{
    public InvalidRoleException(RoleName role){
        idError = 2;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + " :" + role + " no es un rol valido.");
    }
}
