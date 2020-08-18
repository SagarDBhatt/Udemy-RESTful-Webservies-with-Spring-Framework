package com.onslearning.udemyrestfulwebservices.DependencyInjection;

import com.onslearning.udemyrestfulwebservices.Entity.User;

public interface UserService {
    User createUserDI(User userObjectFromURL);
}
