package com.onslearning.udemyrestfulwebservices.DependencyInjection;

import com.onslearning.udemyrestfulwebservices.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    getUserID userIDObject;

    /**
     * Constructor Based Dependency Injection.
     */
    @Autowired
    public UserServiceImpl(getUserID userIDObject){
        this.userIDObject = userIDObject;
    }

    public UserServiceImpl() {
    }

    /**
     * Setter Based Dependency Injection.
     * @param userIDObject
     */
    @Autowired
    public void setUserIDObject(getUserID userIDObject) {
        this.userIDObject = userIDObject;
    }

    @Override
    public User createUserDI(User userObjectFromURL) {

        User userDI = new User(userIDObject.createUserID(), userObjectFromURL.getUserName(),
                                userObjectFromURL.getAge(), userObjectFromURL.getSalary());
        return userDI;
    }



}
