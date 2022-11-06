package com.bluebird.DreamEducation.controllers;

import com.bluebird.DreamEducation.entities.FanYonalish;
import com.bluebird.DreamEducation.results.ResultData;
import com.bluebird.DreamEducation.services.FanYonalishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fan_yonalish")
public class FanYonalishController {
    final FanYonalishService fanYonalishService;

    public FanYonalishController(FanYonalishService fanYonalishService) {
        this.fanYonalishService = fanYonalishService;
    }

    @PostMapping("/add")
    public ResponseEntity<ResultData> add(@RequestParam Long uID, @RequestParam Long fID, @RequestParam Long yID){
        return  ResponseEntity.ok(fanYonalishService.addFanYonalish( fID, yID,uID));
    }

    @GetMapping("/all")
    public ResponseEntity<List<FanYonalish>> getAll(){
        return  ResponseEntity.ok(fanYonalishService.getAll());
    }


}
