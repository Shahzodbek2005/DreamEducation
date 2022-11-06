package com.bluebird.DreamEducation.controllers;

import com.bluebird.DreamEducation.entities.Xodimlar;
import com.bluebird.DreamEducation.results.ResultData;
import com.bluebird.DreamEducation.services.XodimlarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("api/xodimlar")
public class XodimlarController {

    @Autowired
    XodimlarService xodimlarService;

    @PostMapping("/add")
    public ResponseEntity<ResultData> addXodim(@RequestParam String ismi,@RequestParam String familiyasi,@RequestParam String otasi,@RequestParam String passportSeriya,@RequestParam String telefonRaqami1,@RequestParam String telefonRaqami2,@RequestParam Date tugilganSana,@RequestParam Long userID){
        return ResponseEntity.ok(xodimlarService.addXodim(ismi, familiyasi, otasi, passportSeriya, telefonRaqami1, telefonRaqami2, tugilganSana, userID));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Xodimlar>> getAll(){
        return  ResponseEntity.ok(xodimlarService.getAll());
    }


}
