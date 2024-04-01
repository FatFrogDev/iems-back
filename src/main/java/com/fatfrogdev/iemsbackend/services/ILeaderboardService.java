package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.LeaderboardViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;

public interface ILeaderboardService {

    LeaderboardViewDTO save(LeaderboardRegisterDTO leaderboardRegisterDTO);
}
