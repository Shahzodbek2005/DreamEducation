package com.bluebird.DreamEducation.services;

import com.bluebird.DreamEducation.entities.Fan;
import com.bluebird.DreamEducation.entities.FanYonalish;
import com.bluebird.DreamEducation.entities.Users;
import com.bluebird.DreamEducation.entities.Yonalish;
import com.bluebird.DreamEducation.repositories.FanRepo;
import com.bluebird.DreamEducation.repositories.FanYonalishRepo;
import com.bluebird.DreamEducation.repositories.UsersRepo;
import com.bluebird.DreamEducation.repositories.YonalishRepo;
import com.bluebird.DreamEducation.results.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FanYonalishService {
    @Autowired
    FanYonalishRepo fanYonalishRepo;
    @Autowired
    FanRepo fanRepo;
    @Autowired
    YonalishRepo yonalishRepo;

    @Autowired
    UsersRepo usersRepo;

    public ResultData addFanYonalish(Long fID, Long yID, Long uID) {
        Boolean isExists = fanYonalishRepo.checkExists(fID, yID) == 0;
        Fan fan = fanRepo.findById(fID).orElse(null);
        Yonalish yonalish = yonalishRepo.findById(yID).orElse(null);
        Users user = usersRepo.findById(uID).orElse(null);
        if (isExists) {
            if (fan != null && yonalish != null && user != null) {
                FanYonalish fanYonalish = new FanYonalish();
                fanYonalish.setFan(fan);
                fanYonalish.setYonalish(yonalish);
                fanYonalish.setUser(user);
                fanYonalishRepo.save(fanYonalish);
                return new ResultData(true, "Saved");
            } else {
                return new ResultData(false, "Not Saved");
            }
        } else {

            return new ResultData(false, "This data is already exist");
        }

    }

    public List<FanYonalish> getAll() {
        return fanYonalishRepo.findAll();
    }
}
