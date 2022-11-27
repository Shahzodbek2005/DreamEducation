package com.bluebird.DreamEducation.controllers;

import com.bluebird.DreamEducation.entities.TraceModel;
import com.bluebird.DreamEducation.results.ForTimeModel;
import com.bluebird.DreamEducation.results.TopRankModel;
import com.bluebird.DreamEducation.services.TraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("management")
public class ActuatorController {
    @Autowired
    TraceService traceService;

    @GetMapping("traces")
    public ResponseEntity<List<TraceModel>> getWeeklyTraces(@RequestParam String intervalType) {
        return ResponseEntity.ok(traceService.getTraces(intervalType));
    }

    @GetMapping("short-stats")
    public ResponseEntity<ForTimeModel> getWeeklyStats(@RequestParam String intervalType) {
        return ResponseEntity.ok(traceService.getAllStats(intervalType));
    }

    @GetMapping("top-rank")
    public ResponseEntity<List<TopRankModel>> getTopRank(@RequestParam String intervalType) {
        return ResponseEntity.ok(traceService.topRank(intervalType));
    }
}
