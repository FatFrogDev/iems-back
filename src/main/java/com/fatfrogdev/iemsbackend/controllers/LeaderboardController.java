package com.fatfrogdev.iemsbackend.controllers;

import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardViewDTO;
import com.fatfrogdev.iemsbackend.services.ILeaderboardDetailsService;
import com.fatfrogdev.iemsbackend.services.ILeaderboardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/leaderboards")
public class LeaderboardController {

    private final ILeaderboardService leaderboardService;

    private final ILeaderboardDetailsService leaderboardDetailsService;

    @PostMapping("/save")
    public ResponseEntity<LeaderboardViewDTO> save(@RequestBody LeaderboardRegisterDTO leaderboardRegisterDTO) {
        System.out.println(leaderboardRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(leaderboardService.saveLeaderboard(leaderboardRegisterDTO));
    }

    @GetMapping("/{leaderboardId}/details")
    public ResponseEntity<LeaderboardViewDTO> findById(@PathVariable String leaderboardId, @RequestParam(value = "order", required = false) String order){
        return ResponseEntity.status(HttpStatus.OK).body(leaderboardService.findById(leaderboardId, order));
    }


}