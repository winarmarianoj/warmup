package com.marianowinar.warmup.dto.request;

import javax.validation.constraints.*;

import static com.marianowinar.warmup.model.User.*;

public class UserDto {

    @NotNull(message = "email cannot be null.")
    @NotBlank(message = "email cannot be empty.")
    @Size(min = MIN_USERNAME_SIZE, message = "email must contain at least "
            + MIN_USERNAME_SIZE + " characters.")
    @Size(max = MAX_USERNAME_SIZE, message = "email must contain less than "
            + MAX_USERNAME_SIZE + " characters.")
    @Email(message="Please provide a valid email address")
    //@Pattern(regexp="^([a-zA-Z0-9-._ñ]+)@([a-zA-Z0-9-._ñ]+).([a-zA-Z]{2,5})$", message="Please provide a valid email address")
    private String email;

    @NotNull(message = "password cannot be null.")
    @NotBlank(message = "password cannot be empty.")
    @Size(min = MIN_PASSWORD_SIZE, message = "password must contain at least "
            + MIN_PASSWORD_SIZE + " characters.")
    @Size(max = MAX_PASSWORD_SIZE,  message = "password must contain less than "
            + MAX_PASSWORD_SIZE + " characters.")
    private String password;

    @NotNull(message = "role cannot be null.")
    @NotBlank(message = "role cannot be empty.")
    private String type;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

}
