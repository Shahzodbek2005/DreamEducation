package com.bluebird.DreamEducation.services;

import com.bluebird.DreamEducation.entities.Fan;
import com.bluebird.DreamEducation.entities.Users;
import com.bluebird.DreamEducation.repositories.FanRepo;
import com.bluebird.DreamEducation.repositories.UsersRepo;
import com.bluebird.DreamEducation.results.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FanServices {


    @Autowired
    FanRepo fanRepo;

    @Autowired
    UsersRepo usersRepo;


    public ResultData addFan(String name, Long uID){

        Users user = usersRepo.findById(uID).orElse(null);
        Fan fan = new Fan();
        if(user != null){
            fan.setNomi(name);
            fan.setUser(user);
           // fan.setUserID(user);
            fanRepo.save(fan);
            return new ResultData(true, "Saved");
        }
        else{
            return new ResultData(false, "Not Saved");

        }


    }

    public ResultData getFan(Long id){

        return new ResultData(fanRepo.findById(id).orElse(null)!=null,fanRepo.findById(id).orElse(null)) ;
    }
    public List<Fan> getAll(){
        return fanRepo.findAll();
    }
}
