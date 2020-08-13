package com.onslearning.udemyrestfulwebservices.Entity;

public class UserDetailModelRequest {
    //Private field name should match the JSON Payload Entity Name ex. "firstName", "lastName", "email", "age".
    private String firstName;
    private String lastName;
    private String email;
    private String age;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
