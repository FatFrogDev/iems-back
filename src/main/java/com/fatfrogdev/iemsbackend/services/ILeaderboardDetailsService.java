package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsViewDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;

import java.util.List;

public interface ILeaderboardDetailsService {

    void saveLeaderboardDetailsCollection(LeaderboardRegisterDTO leaderboardRegisterDTO, LeaderboardEntity leaderboardEntity);

    List<LeaderboardDetailsViewDTO> findById(String leaderboardId, String customOrder);
}
