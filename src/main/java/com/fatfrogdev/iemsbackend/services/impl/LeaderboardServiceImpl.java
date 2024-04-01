package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.domain.DTOS.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.LeaderboardViewDTO;
import com.fatfrogdev.iemsbackend.repositories.ILeaderboardRepository;
import com.fatfrogdev.iemsbackend.services.ILeaderboardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@AllArgsConstructor
@Service
public class LeaderboardServiceImpl implements ILeaderboardService {

    private final ILeaderboardRepository leaderboardRepository;

    @Override
    public LeaderboardViewDTO save(LeaderboardRegisterDTO leaderboardRegisterDTO) {
        return null;
    }
}
