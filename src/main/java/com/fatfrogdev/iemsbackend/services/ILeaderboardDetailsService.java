package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsViewDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;

import java.util.List;

public interface ILeaderboardDetailsService {

    List<LeaderboardDetailsViewDTO> findLeaderboardDetailsByIdAndOrder(String leaderboardId, String customOrder);

    void saveLeaderboardDetailsCollection(LeaderboardRegisterDTO leaderboardRegisterDTO, LeaderboardEntity leaderboardEntity);

    LeaderboardViewDTO findById(String leaderboardId, String customOrder);
}
