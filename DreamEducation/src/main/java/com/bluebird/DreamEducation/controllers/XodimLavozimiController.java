package com.bluebird.DreamEducation.controllers;

import com.bluebird.DreamEducation.entities.XodimLavozimi;
import com.bluebird.DreamEducation.results.ResultData;
import com.bluebird.DreamEducation.services.XodimLavozimiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/xodim_lavozim")
public class XodimLavozimiController {

    @Autowired
    XodimLavozimiService xodimLavozimiService;

    @PostMapping("/add")
    public ResponseEntity<ResultData> addXodimLavozimi(@RequestParam Long xodimID,@RequestParam Long lavozimID,@RequestParam Long userID){
     return ResponseEntity.ok(xodimLavozimiService.addXodimLavozimi(xodimID, lavozimID, userID));
    }

    @GetMapping("/all")
    public ResponseEntity<List<XodimLavozimi>> getAll(){
        return ResponseEntity.ok(xodimLavozimiService.getAll());
    }
}
