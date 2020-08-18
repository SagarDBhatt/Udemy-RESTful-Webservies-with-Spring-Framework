package com.onslearning.udemyrestfulwebservices.DependencyInjection;

import com.onslearning.udemyrestfulwebservices.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User createUserDI(User userObjectFromURL) {

        User userDI = new User(userObjectFromURL.getUserID(), userObjectFromURL.getUserName(),
                                userObjectFromURL.getAge(), userObjectFromURL.getSalary());
        return userDI;
    }


}
