package com.fatfrogdev.iemsbackend.converters;

import com.fatfrogdev.iemsbackend.domain.DTOS.LeaderboardDetailsRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardDetailsEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import static com.fatfrogdev.iemsbackend.converters.BaseConverter.baseMapper;

@Component
@Log4j2
public class LeaderboardConverter {
    public LeaderboardDetailsEntity leaderboardDetailsRegisterDtoToEntity(LeaderboardDetailsRegisterDTO leaderboardRegisterDTO) {
        try {
            return baseMapper().map(leaderboardRegisterDTO, LeaderboardDetailsEntity.class);
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }
}
