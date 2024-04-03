package com.fatfrogdev.iemsbackend.controllers;

import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardViewDTO;
import com.fatfrogdev.iemsbackend.services.ILeaderboardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/leaderboards")
public class LeaderboardController {

    private final ILeaderboardService leaderboardService;

    @GetMapping("/{id}{order}")
    public ResponseEntity<List<LeaderboardViewDTO>> findById(@PathVariable String id, @RequestParam(value = "order", required = false) String order){
        return ResponseEntity.status(HttpStatus.FOUND).body(leaderboardService.findById(id, order));
    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody LeaderboardRegisterDTO leaderboardRegisterDTO) {
        System.out.println(leaderboardRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(leaderboardService.saveLeaderboard(leaderboardRegisterDTO));
    }
}
