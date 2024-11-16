package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardViewDTO;


public interface ILeaderboardService {

    LeaderboardViewDTO saveLeaderboard(LeaderboardRegisterDTO leaderboardRegisterDTO);

    LeaderboardViewDTO findById(String LeaderboardId, String order);
}
