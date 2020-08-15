package com.onslearning.udemyrestfulwebservices.Entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    //@NotNull(message="UserID should not be null")
    private String userID;

    @NotEmpty(message = "UserName should not be empty")
    private String userName;

    @NotNull
    //@Size(min = 1, max = 100, message = "Age must be between 1 to 100")
    private int age;

    @NotNull(message = "Salary should not be empty")
    private int salary;

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public User(String userID, String userName, int age, int salary) {
        this.userID = userID;
        this.userName = userName;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
