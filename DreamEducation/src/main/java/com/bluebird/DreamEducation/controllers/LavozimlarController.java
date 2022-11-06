package com.bluebird.DreamEducation.controllers;

import com.bluebird.DreamEducation.entities.Lavozim;
import com.bluebird.DreamEducation.results.ResultData;
import com.bluebird.DreamEducation.services.LavozimlarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lavozimlar")
public class LavozimlarController {
    @Autowired
    LavozimlarService lavozimlarService;

    @PostMapping("/add")
    public ResponseEntity<ResultData> addLavozim(@RequestParam String nomi,@RequestParam Long userID){
        return ResponseEntity.ok(lavozimlarService.addLavozim(nomi, userID));

    }

    @GetMapping("/all")
    public ResponseEntity<List<Lavozim>> getAll(){
        return  ResponseEntity.ok(lavozimlarService.getAll());
    }
}
