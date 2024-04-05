package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.LeaderboardConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsViewDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.ClientEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardDetailsEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import com.fatfrogdev.iemsbackend.repositories.ILeaderboardDetailsRepository;
import com.fatfrogdev.iemsbackend.repositories.ILeaderboardRepository;
import com.fatfrogdev.iemsbackend.repositories.IProductRepository;
import com.fatfrogdev.iemsbackend.services.ILeaderboardDetailsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LeaderboardDetailsServiceImpl implements ILeaderboardDetailsService {

    private final ILeaderboardRepository leaderboardRepository;

    private final ILeaderboardDetailsRepository leaderboardDetailsRepository;

    private final IProductRepository productRepository;

    private final LeaderboardConverter leaderboardConverter;

    @Override
    public List<LeaderboardDetailsViewDTO> findLeaderboardDetailsByIdAndOrder(String leaderboardId, String customOrder) {
        Optional<List<Object[]>> leaderboardDetails = leaderboardRepository.findLeaderboardDetailsByIdAndOrder(leaderboardId, customOrder);
        if (leaderboardDetails.isPresent()){
            return leaderboardConverter.objectListToDetailsViewDTO(leaderboardDetails.get());
        }throw new EntityNotFoundException("Leaderboard details with id: " + leaderboardId + " not found :(");
    }

    @Override
    public void saveLeaderboardDetailsCollection(LeaderboardRegisterDTO leaderboardRegisterDTO, LeaderboardEntity leaderboardEntity){ // TODO: Add commit/rollback exception.

        List<LeaderboardDetailsEntity> leaderboardDetailsEntityList = new ArrayList<>();

        for (int index = 0; index < leaderboardRegisterDTO.getLeaderboardDetails().size(); index++) {

            ProductEntity productEntity = findProductIdByProductNameAndProductBrand(
                    leaderboardRegisterDTO.getLeaderboardDetails().get(index).getProduct(),
                    leaderboardRegisterDTO.getLeaderboardDetails().get(index).getBrand()
            );

            leaderboardDetailsEntityList.add(
                    mergeLeaderboardDetailsEntity(
                            leaderboardRegisterDTO.getLeaderboardDetails().get(index),
                            leaderboardEntity,
                            leaderboardEntity.getClient(),
                            productEntity
                    )
            );
        }
        //TODO: validations to assert that list is not null.
        if (leaderboardDetailsEntityList.size()==leaderboardRegisterDTO.getLeaderboardDetails().size()) {
            leaderboardDetailsRepository.saveAll(leaderboardDetailsEntityList);
        }
        else throw new IllegalArgumentException("Leaderboard details list is not the same size as the DTO list");
    }

    @Override
    public LeaderboardViewDTO findById(String leaderboardId, String customOrder) {
        customOrder = customOrder == null ? "asc" : customOrder;
        Optional<LeaderboardEntity> optLeaderboardEntity = leaderboardRepository.findById(leaderboardId);

        if (optLeaderboardEntity.isPresent()) {

            Optional<List<Object[]>> optLeaderboardDetails = leaderboardRepository.findLeaderboardDetailsByIdAndOrder(leaderboardId, customOrder);

            if (optLeaderboardDetails.isPresent()) {
                List<LeaderboardDetailsViewDTO> leaderboardDetailsViewDTOS = leaderboardConverter.objectListToDetailsViewDTO(optLeaderboardDetails.get());
                return LeaderboardViewDTO.builder()
                    .leaderboardId(optLeaderboardEntity.get().getLeaderboardId())
                    .leaderboardName(optLeaderboardEntity.get().getName())
                    .clientUsername(optLeaderboardEntity.get().getClient().getUser().getUsername())
                    .leaderboardDetails(leaderboardDetailsViewDTOS)
                    .build();
                }
            throw new EntityNotFoundException("Leaderboard not found :(");
        } throw new EntityNotFoundException("Leaderboard details not found :(");
    }

    private LeaderboardDetailsEntity mergeLeaderboardDetailsEntity(LeaderboardDetailsRegisterDTO leaderboardDetailsRegisterDTO, LeaderboardEntity leaderboardEntity, ClientEntity clientEntity, ProductEntity productEntity) {
        return leaderboardConverter.DetailsRegisterDtoToDetailsEntity(leaderboardDetailsRegisterDTO, leaderboardEntity, clientEntity, productEntity);
    }

    private ProductEntity findProductIdByProductNameAndProductBrand(String productName, String productBrand) {
        Optional<String> optProductId = productRepository.findProductIdByProductNameAndProductBrand(productName,productBrand);
        if (optProductId.isPresent())
            return ProductEntity.builder().productId(optProductId.get()).build();
        throw new EntityNotFoundException("Product with name " + productName + " and brand " + productBrand + " not found .");
    }
}
