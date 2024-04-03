package com.fatfrogdev.iemsbackend.converters;

import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.models.ClientEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardDetailsEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.fatfrogdev.iemsbackend.converters.BaseConverter.baseMapper;

@Component
@Log4j2
public class LeaderboardConverter {
    public LeaderboardDetailsEntity DetailsRegisterDtoToDetailsEntity(LeaderboardDetailsRegisterDTO leaderboardRegisterDTO, LeaderboardEntity leaderboardEntity, ClientEntity clientEntity, ProductEntity productEntity) {
        // TODO: validate data is accurate to avoid exceptions.¿
        return LeaderboardDetailsEntity.builder()
                .leaderboard(leaderboardEntity)
                .product(productEntity)
                .productTop(leaderboardRegisterDTO.getProductTop())
                .soundStageAmplitude(leaderboardRegisterDTO.getSoundStageAmplitude())
                .imagePrecision(leaderboardRegisterDTO.getImagePrecision())
                .subBassQualityQuantity(leaderboardRegisterDTO.getSubBassQualityQuantity())
                .bassQualityQuantity(leaderboardRegisterDTO.getBassQualityQuantity())
                .mediumBassQualityQuantity(leaderboardRegisterDTO.getMediumBassQualityQuantity())
                .midRangeQualityQuantity(leaderboardRegisterDTO.getMidRangeQualityQuantity())
                .trebleQualityQuantity(leaderboardRegisterDTO.getTrebleQualityQuantity())
                .sibilanceControl(leaderboardRegisterDTO.getSibilanceControl())
                .isBassHead(leaderboardRegisterDTO.isBassHead())
                .monitoringLiveStudio(leaderboardRegisterDTO.getMonitoringLiveStudio())
                .isFunny(leaderboardRegisterDTO.isFunny())
                .videoGamesPerformance(leaderboardRegisterDTO.getVideoGamesPerformance())
                .buildQuality(leaderboardRegisterDTO.getBuildQuality())
                .comfort(leaderboardRegisterDTO.getComfort())
                .cableQuality(leaderboardRegisterDTO.getCableQuality())
                .build();
    }

    public LeaderboardEntity registerDtoToLeaderboardEntity(LeaderboardRegisterDTO leaderboardRegisterDTO, ClientEntity clientEntity) {
        // TODO: validate data is accurate to avoid null pointer exceptions (DTO & ClientEntity).
        return LeaderboardEntity.builder()
                .leaderboardId(null)
                .client(clientEntity)
                .name(leaderboardRegisterDTO.getLeaderboardName())
                .build();
    }

}
