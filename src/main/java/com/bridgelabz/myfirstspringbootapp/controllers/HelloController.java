package com.bridgelabz.myfirstspringbootapp.controllers;

import com.bridgelabz.myfirstspringbootapp.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World bridgelabz!!";
    }

    @GetMapping("/param/hello")
    public String paramHello(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return "Hello" +" "+ firstName + " " +lastName;
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name")String name){
        return "Hello" +name + "!";
    }

    @PostMapping("postbody/hello")
    public String postBodyHello(@RequestBody User user){
        return user.getFirstName() + " " + user.getLastName();
    }

    @PutMapping("putbody/hello")
    public ResponseEntity<User> putHello(@RequestBody User user){
        User newUser = new User();
        newUser.setFirstName("Sheetal");
        newUser.setLastName("Chaudhari");
        //return  user.getFirstName() + " " + user.getLastName();
        //return "User has been updated"
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PutMapping("put/{firstName}")
    public String sayHello(@PathVariable String firstName, @RequestParam(value = "lastName")String lastName){
        return "Hello" + firstName + " " + lastName + "!";
    }
}
