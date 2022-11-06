package com.bluebird.DreamEducation.controllers;

import com.bluebird.DreamEducation.entities.Users;
import com.bluebird.DreamEducation.results.ResultData;
import com.bluebird.DreamEducation.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }
    @GetMapping("/user")
    public ResponseEntity<Boolean> isUserExists(@RequestParam String username, @RequestParam String password){
        return  ResponseEntity.ok(userServices.findUser(username, password));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers(){
     return ResponseEntity.ok(userServices.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<ResultData> addNewUser(@RequestParam String username, @RequestParam String password){
        return ResponseEntity.ok(userServices.saveUser(username, password));
    }
}
