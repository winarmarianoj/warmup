package com.marianowinar.warmup.util.validator;

import com.marianowinar.warmup.exception.user.InvalidEmailException;
import com.marianowinar.warmup.exception.user.InvalidPasswordUserException;
import com.marianowinar.warmup.exception.user.NullUserException;
import com.marianowinar.warmup.exception.user.UserException;
import com.marianowinar.warmup.model.User;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ValidUser {

    public void validCreateUser(User user) throws UserException {
        if(user == null)
            throw new NullUserException();

        validUsername(user.getUsername());
        validPassword(user.getPassword());
    }

    public void validPassword(String password) throws InvalidPasswordUserException {
        if(password == null)
            throw new InvalidPasswordUserException("Password null");

        if (!Pattern.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$", password))
            throw new InvalidPasswordUserException("Password invalid format");
    }

    public void validUsername(String username) throws InvalidEmailException {
        if(username == null)
            throw new InvalidEmailException("Email null");

        if(!Pattern.matches("^([a-zA-Z0-9-._ñ]+)@([a-zA-Z0-9-._ñ]+).([a-zA-Z]{2,5})$", username))
            throw new InvalidEmailException("Email no válido");
    }
}
