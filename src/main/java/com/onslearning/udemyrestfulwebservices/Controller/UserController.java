package com.onslearning.udemyrestfulwebservices.Controller;

import com.onslearning.udemyrestfulwebservices.Entity.User;
import com.onslearning.udemyrestfulwebservices.Entity.UserDataValidation;
import com.onslearning.udemyrestfulwebservices.Entity.UserDetailModelRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")        // localhost:8084/users
public class UserController {

    Map<String, User> userMap = new HashMap<String, User>();

    // @RequestMapping(method = RequestMethod.GET,value = "/getUser")
    @GetMapping(value = "/getUser")
    public String getUser() {
        return "Get user method is called.";
    }

    @GetMapping(value = "/{userID}")        //http://localhost:8084/users/1
    public User getUserByID(@PathVariable String userID) {
        User aUser = new User(userID, "Sam", 25, 1000);
        return aUser;
        //return "The user with the user ID = " + userID;
    }

    @GetMapping(value = "/response/{uId}")
    public ResponseEntity<User> getUserResponse(@PathVariable(value = "uId") String uID) {
        User userObject = new User(uID, "Sagar", 25, 2000);
        ResponseEntity<User> responseEntityUser = new ResponseEntity<User>(userObject, HttpStatus.OK);

        return responseEntityUser;
    }

    @GetMapping             //http://localhost:8084/users?page=1&limit=40
    public String getUserByPage(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit) {
        return "User on the page = " + page + " with limit = " + limit;
    }

    @GetMapping(value = "/optParam")                    //http://localhost:8084/users/optParam?name=Sagar&city=Denver
    public String getUserOptionalParam(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "city", required = false) String city) {
        return "Optional Param Name = " + name + " city = " + city;
    }

    // 1, POST request to map JSON payload to Java object and create a new object to pass the data.
    @PostMapping(consumes =
            {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserDetailModelRequest> creatUser(@RequestBody UserDetailModelRequest userObjectFromURL) {

        UserDetailModelRequest userObject = new UserDetailModelRequest();
        userObject.setFirstName(userObjectFromURL.getFirstName());
        userObject.setLastName(userObjectFromURL.getLastName());
        userObject.setEmail(userObjectFromURL.getEmail());
        userObject.setAge(userObjectFromURL.getAge());

        return new ResponseEntity<UserDetailModelRequest>(userObject, HttpStatus.OK);
    }

//2. Post request with Data validation on JSON Payload. Validate Email, first & last name, password.

    @PostMapping(value = "/validate",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    public ResponseEntity<UserDataValidation> userValidate(@Valid @RequestBody UserDataValidation validationObject) {

        UserDataValidation newObject =
                new UserDataValidation(
                        validationObject.getFirstName(),
                        validationObject.getLastName(),
                        validationObject.getEmail(),
                        validationObject.getPassword()
                );

        System.out.println(validationObject.getFirstName());
        ResponseEntity<UserDataValidation> responseEntity = new
                ResponseEntity<UserDataValidation>(newObject, HttpStatus.OK);

        return responseEntity;
    }

//3. Post request to create a USER. Temporarily Store it in Map and retrive the user details by Get request by providing ID.

    @PostMapping(value = "/retrieve",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String createUserMap(@Valid @RequestBody User aUser) {

        String userID = UUID.randomUUID().toString();
        User userObject = new User(userID, aUser.getUserName(), aUser.getAge(), aUser.getSalary());

        userMap.put(userID, userObject);

        return " User with UserID = " + userID + " added successfully!!!";
    }

//4. Retrieve User details with UserID. User details were just added.

    @GetMapping(value = "/retrieve/{uid}")
    public ResponseEntity<User> retriveUserWithUID(@PathVariable(value = "uid") String uid) {
        if (userMap.containsKey(uid)) {
            return new ResponseEntity<User>(userMap.get(uid), HttpStatus.OK);
        } else
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

// 5. PUT request to update User Details:

    @PutMapping(value = "/{userIdWeb}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> updateUserDetails(@PathVariable(value = "userIdWeb") String userIdWeb, @RequestBody User userUpdate) {
        User updatedUser = null;
        if (userMap.containsKey(userIdWeb)) {
            updatedUser = new User(userIdWeb, userUpdate.getUserName(), userUpdate.getAge(), userUpdate.getSalary());
        }
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

// 6. Delete request to delete user:

    @DeleteMapping(value = "/{userID}")
    public String deleteUser(@PathVariable(value = "userID") String userID) {

        if (userMap.containsKey(userID)) {
            userMap.remove(userID);
            return "User with user id = " + userID + " deleted";
        }
        else
            return "Unable to delete!";
    }


}//End of class UserController.
