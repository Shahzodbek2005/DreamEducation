package com.bluebird.DreamEducation.services;

import com.bluebird.DreamEducation.entities.Lavozim;
import com.bluebird.DreamEducation.entities.Users;
import com.bluebird.DreamEducation.repositories.LavozimlarRepo;
import com.bluebird.DreamEducation.repositories.UsersRepo;
import com.bluebird.DreamEducation.results.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LavozimlarService {

    @Autowired
    LavozimlarRepo lavozimlarRepo;

    @Autowired
    UsersRepo usersRepo;

    public ResultData addLavozim(String nomi, Long userId){
        Users user = usersRepo.findById(userId).orElse(null);
        if (user != null) {
            Lavozim lavozim = new Lavozim();
            lavozim.setNomi(nomi);
            lavozim.setUser(user);
            lavozimlarRepo.save(lavozim);
            return new ResultData(true, "Saved");
        } else {
            return new ResultData(false, "Not saved");
        }
    }

    public List<Lavozim> getAll(){
        return lavozimlarRepo.findAll();
    }
}
