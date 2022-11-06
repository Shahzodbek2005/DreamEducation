package com.bluebird.DreamEducation.controllers;
import com.bluebird.DreamEducation.entities.Yonalish;
import com.bluebird.DreamEducation.results.ResultData;
import com.bluebird.DreamEducation.services.YonalishServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/yonalishlar")
public class YonalishController {

    final YonalishServices fanServices;

    public YonalishController(YonalishServices fanServices) {
        this.fanServices = fanServices;
    }

    @GetMapping("/yonalish")
    public ResponseEntity<ResultData> getFanById(@RequestParam Long id){
        return  ResponseEntity.ok(fanServices.getYonalish(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Yonalish>> getAllFan(){
        return ResponseEntity.ok(fanServices.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<ResultData> addNewYonalish(@RequestParam String name, @RequestParam Long uID){
        return  ResponseEntity.ok(fanServices.addYonalish(name, uID));}
}
