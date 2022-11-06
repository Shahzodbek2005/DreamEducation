package com.bluebird.DreamEducation.services;
import com.bluebird.DreamEducation.entities.Users;
import com.bluebird.DreamEducation.repositories.UsersRepo;
import com.bluebird.DreamEducation.results.ResultData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    final UsersRepo usersRepo;

    public UserServices(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }
    public Boolean findUser(String username, String password){
        return usersRepo.findUser(username, password) != null;
    }
    public ResultData saveUser(String username, String password){
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
       try {
           usersRepo.save(user);
           return  new ResultData(true, "Saved");
       }catch (Exception e){
           return new ResultData(false, "Not Saved");
       }

    }

    public List<Users> getAll(){
     return    usersRepo.findAll();
    }
}
