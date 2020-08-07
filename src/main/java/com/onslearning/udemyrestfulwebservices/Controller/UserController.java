package com.onslearning.udemyrestfulwebservices.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")        // localhost:8084/users
public class UserController {

   // @RequestMapping(method = RequestMethod.GET,value = "/getUser")
    @GetMapping(value = "/getUser")
    public String getUser(){
        return "Get user method is called.";
    }

    @GetMapping(value = "/{userID}")        //http://localhost:8084/users/1
    public String getUserByID(@PathVariable String userID){
        return "The user with the user ID = " + userID;
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
