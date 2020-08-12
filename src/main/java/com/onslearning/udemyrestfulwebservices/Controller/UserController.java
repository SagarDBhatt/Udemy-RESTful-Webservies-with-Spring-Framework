package com.onslearning.udemyrestfulwebservices.Controller;

import com.onslearning.udemyrestfulwebservices.Entity.User;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("users")        // localhost:8084/users
public class UserController {

   // @RequestMapping(method = RequestMethod.GET,value = "/getUser")
    @GetMapping(value = "/getUser")
    public String getUser(){
        return "Get user method is called.";
    }

    @GetMapping(value = "/{userID}", produces = {MediaType.})        //http://localhost:8084/users/1
    public User getUserByID(@PathVariable String userID){
        User aUser = new User(Integer.parseInt(userID),"Sam", 25, 1000);
        return aUser;
        //return "The user with the user ID = " + userID;
    }

    @GetMapping             //http://localhost:8084/users?page=1&limit=40
    public String getUserByPage(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit){
        return "User on the page = "+ page + " with limit = " + limit;
    }

    @GetMapping(value = "/optParam")                    //http://localhost:8084/users/optParam?name=Sagar&city=Denver
    public String getUserOptionalParam(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "city", required = false) String city){
        return "Optional Param Name = " + name + " city = " + city;
    }

}
