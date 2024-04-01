package com.fatfrogdev.iemsbackend.converters;

import com.fatfrogdev.iemsbackend.domain.DTOS.LeaderboardRegisterDTO;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> findById() {
        return null;
    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody LeaderboardRegisterDTO leaderboardRegisterDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(leaderboardService.save(leaderboardRegisterDTO));
    }
}
