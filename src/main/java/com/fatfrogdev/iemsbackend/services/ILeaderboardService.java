package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.LeaderboardViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardDetailsEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;

import java.util.List;

public interface ILeaderboardService {

    // Saves the leaderboard details entity and the leaderboard entity then returns a leaderboard view DTO.
    LeaderboardViewDTO saveLeaderboardDetailsCollection(LeaderboardEntity leaderboardEntity, List<LeaderboardDetailsEntity> leaderboardDetailsEntityList);

    LeaderboardEntity saveLeadearboardEntity(LeaderboardRegisterDTO leaderboardRegisterDTO);
}
