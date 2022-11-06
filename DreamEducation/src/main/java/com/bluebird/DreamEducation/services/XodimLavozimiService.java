package com.bluebird.DreamEducation.services;

import com.bluebird.DreamEducation.entities.Lavozim;
import com.bluebird.DreamEducation.entities.Users;
import com.bluebird.DreamEducation.entities.XodimLavozimi;
import com.bluebird.DreamEducation.entities.Xodimlar;
import com.bluebird.DreamEducation.repositories.LavozimlarRepo;
import com.bluebird.DreamEducation.repositories.UsersRepo;
import com.bluebird.DreamEducation.repositories.XodimLavozimiRepo;
import com.bluebird.DreamEducation.repositories.XodimlarRepo;
import com.bluebird.DreamEducation.results.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XodimLavozimiService {

    @Autowired
    XodimLavozimiRepo xodimLavozimiRepo;

    @Autowired
    XodimlarRepo xodimlarRepo;

    @Autowired
    LavozimlarRepo lavozimlarRepo;

    @Autowired
    UsersRepo usersRepo;

    public ResultData addXodimLavozimi(Long xodimID, Long lavozimID, Long userID){
        Boolean isExists = xodimLavozimiRepo.checkExists(lavozimID, xodimID) == 0;
        Xodimlar xodimlar = xodimlarRepo.findById(xodimID).orElse(null);
        Lavozim lavozim = lavozimlarRepo.findById(lavozimID).orElse(null);
        Users user = usersRepo.findById(userID).orElse(null);
        if (isExists) {
            if (user != null && xodimlar != null && lavozim != null) {
                XodimLavozimi xodimLavozimi = new XodimLavozimi();
                xodimLavozimi.setUser(user);
                xodimLavozimi.setXodim(xodimlar);
                xodimLavozimi.setLavozim(lavozim);
                xodimLavozimiRepo.save(xodimLavozimi);
                return new ResultData(true, "Saved");
            } else {
                return new ResultData(false, "Not saved");
            }
        }else{
            return new ResultData(false,"This data is already exist");
        }

    }

    public List<XodimLavozimi> getAll(){
        return xodimLavozimiRepo.findAll();
    }
}
