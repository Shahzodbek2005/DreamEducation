package com.bluebird.DreamEducation.controllers;

import com.bluebird.DreamEducation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class UserRoleController {


    @Autowired
    UserService userService;


    @PostMapping("user-register")
    public ResponseEntity<String> newUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("roleID") Long roleID){
       return ResponseEntity.ok(userService.addUser(username, password, roleID));
    }


}
