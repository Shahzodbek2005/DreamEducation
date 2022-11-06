package com.bluebird.DreamEducation.services;

import com.bluebird.DreamEducation.entities.Users;
import com.bluebird.DreamEducation.entities.Xodimlar;
import com.bluebird.DreamEducation.repositories.UsersRepo;
import com.bluebird.DreamEducation.repositories.XodimlarRepo;
import com.bluebird.DreamEducation.results.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class XodimlarService {

    @Autowired
    XodimlarRepo xodimlarRepo;

    @Autowired
    UsersRepo usersRepo;

    public ResultData addXodim(String ismi, String familiyasi, String otasi, String passportSeriya, String telefonRaqami1, String telefonRaqami2, Date tugilganSana, Long userId) {
        Users user = usersRepo.findById(userId).orElse(null);
        if (user != null) {
            Xodimlar xodimlar = new Xodimlar();
            xodimlar.setIsmi(ismi);
            xodimlar.setFamiliyasi(familiyasi);
            xodimlar.setOtasi(otasi);
            xodimlar.setTugilganSana(tugilganSana);
            xodimlar.setUser(user);
            xodimlar.setPassportSeriya(passportSeriya);
            xodimlar.setTelefonRaqami1(telefonRaqami1);
            xodimlar.setTelefonRaqami2(telefonRaqami2);
            xodimlarRepo.save(xodimlar);
            return new ResultData(true, "Saved");
        } else {
            return new ResultData(false, "Not saved");
        }
    }

    public List<Xodimlar> getAll() {
        return xodimlarRepo.findAll();
    }
}
