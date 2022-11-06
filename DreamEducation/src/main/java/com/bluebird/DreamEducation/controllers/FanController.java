package com.bluebird.DreamEducation.controllers;

import com.bluebird.DreamEducation.entities.Fan;
import com.bluebird.DreamEducation.results.ResultData;
import com.bluebird.DreamEducation.services.FanServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fanlar")
public class FanController {
    final FanServices fanServices;

    public FanController(FanServices fanServices) {
        this.fanServices = fanServices;
    }

    @GetMapping("/fan")
    public ResponseEntity<ResultData> getFanById(@RequestParam Long id){
        return  ResponseEntity.ok(fanServices.getFan(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Fan>> getAllFan(){
        return ResponseEntity.ok(fanServices.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<ResultData> addNewFan(@RequestParam String name, @RequestParam Long uID){
        return  ResponseEntity.ok(fanServices.addFan(name, uID));}


}
