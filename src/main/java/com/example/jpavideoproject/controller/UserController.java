package com.example.jpavideoproject.controller;

import com.example.jpavideoproject.model.User;
import com.example.jpavideoproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/makeUser")
    public ResponseEntity<User> makeUser(@ModelAttribute User user){
        System.out.println("received user " + user.getId() + " " + user.getName());
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<Set<User>> getUsers(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findUserById")
    public ResponseEntity<User> findUserById(@RequestParam Long userId){
        User user = userService.findById(userId).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PostMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestParam Long id,@RequestParam String name, @RequestParam int age ){
        /*User user2 = userService.findById(id).get();
        user2.setName(name);
        user2.setAge(age);*/

        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setId(id);
        userService.save(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
