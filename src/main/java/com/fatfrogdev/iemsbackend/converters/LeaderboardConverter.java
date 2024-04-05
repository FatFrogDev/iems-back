package com.fatfrogdev.iemsbackend.converters;

import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsViewDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.models.ClientEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardDetailsEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import static com.fatfrogdev.iemsbackend.domain.models.enumerates.ImagePrecision.*;
import static com.fatfrogdev.iemsbackend.domain.models.enumerates.SoundStageAmplitude.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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


    public List<LeaderboardDetailsViewDTO> objectListToDetailsViewDTO(List<Object[]> results){
        if (results!=null) {
            List<LeaderboardDetailsViewDTO> detailsViewDTOList = new ArrayList<>(results.size());

            for (Object[] result : results) {
                LeaderboardDetailsViewDTO dto = LeaderboardDetailsViewDTO.builder()
                        .productId((String) result[0])
                        .productName((String) result[1])
                        .productBrand((String) result[2])
                        .bassQualityQuantity((String) result[3])
                        .buildQuality((String) result[4])
                        .cableQuality((String) result[5])
                        .comfort((String) result[6])
                        .imagePrecision(
                                convertToImagePrecision(Integer.parseInt(result[7].toString()))
                        )
                        .isBassHead((boolean) result[8])
                        .isFunny((boolean) result[9])
                        .mediumBassQualityQuantity((String) result[10])
                        .midRangeQualityQuantity((String) result[11])
                        .monitoringLiveStudio((String) result[12])
                        .productTop((int) result[13])
                        .sibilanceControl((String) result[14])
                        .soundStageAmplitude(
                                convertToSoundStageAmplitude(Integer.parseInt(result[15].toString()))
                        )
                        .subBassQualityQuantity((String) result[16])
                        .videoGamesPerformance((String) result[17])
                        .build();
                detailsViewDTOList.add(dto);
            }
            return detailsViewDTOList;
        }
    throw new EntityNotFoundException("No results found for stored procedure");
    }
}