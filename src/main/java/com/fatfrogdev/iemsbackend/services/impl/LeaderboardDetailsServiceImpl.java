package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.LeaderboardConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsViewDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardDetailsEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import com.fatfrogdev.iemsbackend.domain.models.UserEntity;
import com.fatfrogdev.iemsbackend.exceptions.WrongArgumentsException;
import com.fatfrogdev.iemsbackend.exceptions.leaderboard.LeaderboardDetailsNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.product.ProductNotFoundException;
import com.fatfrogdev.iemsbackend.repositories.ILeaderboardDetailsRepository;
import com.fatfrogdev.iemsbackend.repositories.ILeaderboardRepository;
import com.fatfrogdev.iemsbackend.repositories.IProductRepository;
import com.fatfrogdev.iemsbackend.services.ILeaderboardDetailsService;
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
    public void saveLeaderboardDetailsCollection(LeaderboardRegisterDTO leaderboardRegisterDTO, LeaderboardEntity leaderboardEntity){ // TODO: Add commit/rollback exception and other exceptions.

        List<LeaderboardDetailsEntity> leaderboardDetailsEntityList = new ArrayList<>();

        for (int index = 0; index < leaderboardRegisterDTO.getLeaderboardDetails().size(); index++) {

            ProductEntity productEntity = this.findProductIdByProductNameAndProductBrand(
                    leaderboardRegisterDTO.getLeaderboardDetails().get(index).getProduct(),
                    leaderboardRegisterDTO.getLeaderboardDetails().get(index).getBrand()
            );

            leaderboardDetailsEntityList.add(
                    this.mergeLeaderboardDetailsEntity(
                            leaderboardRegisterDTO.getLeaderboardDetails().get(index),
                            leaderboardEntity,
                            leaderboardEntity.getUser(),
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
    public List<LeaderboardDetailsViewDTO> findByLeaderboardId(String leaderboardId, String customOrder) {
        if (!customOrder.equals("asc") && !customOrder.equals("desc"))
            throw new WrongArgumentsException(String.format("Error: Order %s is not valid. Use 'asc' or 'desc'.", customOrder));

        Optional<LeaderboardEntity> optLeaderboardEntity = leaderboardRepository.findById(leaderboardId);

        if (optLeaderboardEntity.isPresent()) {
            return  leaderboardConverter.ObjectListToLeaderboardDetailsViewDTO(
                    leaderboardRepository.findLeaderboardDetailsByIdAndOrder(leaderboardId, customOrder)
            );
        } throw new LeaderboardDetailsNotFoundException(String.format("Error: Leaderboard details of leaderboard with id %s not found.", leaderboardId));
    }

    private LeaderboardDetailsEntity mergeLeaderboardDetailsEntity(LeaderboardDetailsRegisterDTO leaderboardDetailsRegisterDTO, LeaderboardEntity leaderboardEntity, UserEntity userEntity, ProductEntity productEntity) {
        return leaderboardConverter.DetailsRegisterDtoToDetailsEntity(leaderboardDetailsRegisterDTO, leaderboardEntity, userEntity, productEntity);
    }

    private ProductEntity findProductIdByProductNameAndProductBrand(String productName, String productBrand) {
        Optional<String> optProductId = productRepository.findProductIdByProductNameAndProductBrand(productName,productBrand);
        if (optProductId.isPresent())
            return new ProductEntity(optProductId.get());
        else
            throw new ProductNotFoundException(String.format("Product with name %s and brand %s not found.", productName, productBrand));
    }

}