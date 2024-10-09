package com.fatfrogdev.iemsbackend.converters;

import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsViewDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardDetailsEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;

import com.fatfrogdev.iemsbackend.domain.models.UserEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Log4j2
public class LeaderboardConverter {
    public LeaderboardDetailsEntity DetailsRegisterDtoToDetailsEntity(LeaderboardDetailsRegisterDTO leaderboardRegisterDTO, LeaderboardEntity leaderboardEntity, UserEntity userEntity, ProductEntity productEntity) {
        // TODO: validate data is accurate to avoid exceptions.¿
        return LeaderboardDetailsEntity.builder()
                .leaderboard(leaderboardEntity)
                .product(productEntity)
                .productTop(leaderboardRegisterDTO.getProductTop())
                .soundStageAmplitude(String.valueOf(leaderboardRegisterDTO.getSoundStageAmplitude()))
                .imagePrecision(String.valueOf(leaderboardRegisterDTO.getImagePrecision()))
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

    public LeaderboardEntity registerDtoToLeaderboardEntity(LeaderboardRegisterDTO leaderboardRegisterDTO, UserEntity userEntity) {
        // TODO: validate data is accurate to avoid null pointer exceptions (DTO & ClientEntity).
        return LeaderboardEntity.builder()
                .leaderboardId(null)
                .name(leaderboardRegisterDTO.getLeaderboardName())
                .user(userEntity)
                .build();
    }

    public List<LeaderboardDetailsViewDTO> ObjectListToLeaderboardDetailsViewDTO(List<Object[]> objectList) {
        List<LeaderboardDetailsViewDTO> leaderboardDetailsViewDTOList = new ArrayList<>(objectList.size());
        for (Object[] object : objectList) {
            leaderboardDetailsViewDTOList.add(LeaderboardDetailsViewDTO.builder()
                    .productId((String) object[0])
                    .productName((String) object[1])
                    .productBrand((String) object[2])
                    .bassQualityQuantity((String) object[3])
                    .buildQuality((String) object[4])
                    .cableQuality((String) object[5])
                    .comfort((String) object[6])
                    .imagePrecision((String) object[7])
                    .isBassHead((Boolean) object[8])
                    .isFunny((Boolean) object[9])
                    .mediumBassQualityQuantity((String) object[10])
                    .midRangeQualityQuantity((String) object[11])
                    .monitoringLiveStudio((String) object[12])
                    .productTop((Integer) object[13])
                    .sibilanceControl((String) object[14])
                    .soundStageAmplitude((String) object[15])
                    .subBassQualityQuantity((String) object[16])
                    .videoGamesPerformance((String) object[17])
                    .build());
        }
        return leaderboardDetailsViewDTOList;
    }
}