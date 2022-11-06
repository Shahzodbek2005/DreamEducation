package com.bluebird.DreamEducation.services;

import com.bluebird.DreamEducation.entities.Users;
import com.bluebird.DreamEducation.entities.Yonalish;
import com.bluebird.DreamEducation.repositories.UsersRepo;
import com.bluebird.DreamEducation.repositories.YonalishRepo;
import com.bluebird.DreamEducation.results.ResultData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YonalishServices {
    final YonalishRepo yonalishRepo;
    final UsersRepo usersRepo;

    public YonalishServices(YonalishRepo yonalishRepo, UsersRepo usersRepo) {
        this.yonalishRepo = yonalishRepo;
        this.usersRepo = usersRepo;
    }

    public ResultData addYonalish(String name, Long uID) {
        Users user = usersRepo.findById(uID).orElse(null);
        if(user!=null){
            Yonalish yonalish = new Yonalish();
            yonalish.setNomi(name);
            yonalish.setUser(user);
            yonalishRepo.save(yonalish);
            return  new ResultData(true, "Saved");
        }
        else{
            return  new ResultData(false, "Not Saved");
        }
    }

    public ResultData getYonalish(Long id) {

        return new ResultData(yonalishRepo.findById(id).orElse(null) != null, yonalishRepo.findById(id).orElse(null));
    }

    public List<Yonalish> getAll() {
        return yonalishRepo.findAll();
    }
}
