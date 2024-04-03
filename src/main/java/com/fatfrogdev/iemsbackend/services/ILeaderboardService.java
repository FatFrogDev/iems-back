package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;

import java.util.List;

public interface ILeaderboardService {
    List<LeaderboardViewDTO> saveLeaderboard(LeaderboardRegisterDTO leaderboardRegisterDTO);


    List<LeaderboardViewDTO> findById(String leaderboardId, String customOrder);

    void saveLeaderboardDetailsCollection(LeaderboardRegisterDTO leaderboardRegisterDTO, LeaderboardEntity leaderboardEntity);

    // Saves the leaderboard details entity and the leaderboard entity then returns a leaderboard view DTO.

}
