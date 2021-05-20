package com.marianowinar.warmup.exception.authentication;

@SuppressWarnings("serial")
public class AuthException extends Exception{
    protected int idError;
    protected String error;

    public AuthException() {}

    public AuthException(String message) {
        super(message);
    }

    public String getError(){
        return this.error;
    }

    protected void setError(String message){
        this.error = message;
    }
}
