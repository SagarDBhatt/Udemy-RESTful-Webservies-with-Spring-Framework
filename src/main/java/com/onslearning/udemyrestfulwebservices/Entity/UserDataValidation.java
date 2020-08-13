package com.onslearning.udemyrestfulwebservices.Entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDataValidation {

    @NotNull(message = "First Name can not be null and must be 2 to 20 characters")
    @Size(min = 2, max = 20)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 20, message = "Last name should be between 2 to 20 characters")
    private String lastName;

    @Email(message = "Please insert valid email address")
    private String email;

    @NotNull(message = "Please insert valid password with length between 8 to 16 characters")
    @Size(min=8,max = 16, message = "Password must be 8 to 16 characters.")
    private String password;

    public UserDataValidation(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
