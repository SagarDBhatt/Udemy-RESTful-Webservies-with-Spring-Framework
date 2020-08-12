package com.onslearning.udemyrestfulwebservices.Entity;

public class User {
    private int userID;
    private String userName;
    private int age;
    private int salary;

    public int getUserID() {
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

    public void setUserID(int userID) {
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

    public User(int userID, String userName, int age, int salary) {
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
