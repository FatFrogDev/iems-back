package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.LeaderboardConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.LeaderboardDetailsRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.LeaderboardViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.ClientEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardDetailsEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import com.fatfrogdev.iemsbackend.repositories.IClientRepository;
import com.fatfrogdev.iemsbackend.repositories.ILeaderboardRepository;
import com.fatfrogdev.iemsbackend.repositories.IProductRepository;
import com.fatfrogdev.iemsbackend.services.ILeaderboardService;
import com.fatfrogdev.iemsbackend.validators.LeaderboardValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class LeaderboardServiceImpl implements ILeaderboardService {

    private final ILeaderboardRepository leaderboardRepository;

    private final LeaderboardValidator leaderboardValidator;

    private final IProductRepository productRepository;

    private final IClientRepository clientRepository;

    private final LeaderboardConverter leaderboardConverter;

    @Override
    public LeaderboardViewDTO saveLeaderboardDetailsCollection(LeaderboardEntity leaderboardEntity, List<LeaderboardDetailsEntity> leaderboardDetailsEntityList) {
        //For to set the leaderboard details entity
        for (int index = 0; index < leaderboardDetailsEntityList.size(); index++) {
            LeaderboardDetailsEntity leaderboardDetailsEntity = leaderboardDetailsEntityList.get(index);
            leaderboardDetailsEntity.setLeaderboard(leaderboardEntity);
            // TODO: Save the list of details entity
        }
        // ;//TODO: DO NOT SAVE HERE
        return null;
    }

    @Override
    public LeaderboardEntity saveLeadearboardEntity(LeaderboardRegisterDTO leaderboardRegisterDTO) {
        return null; //TODO: Implement method
    }

    public LeaderboardDetailsEntity setLeaderboardDetailsEntity (LeaderboardRegisterDTO leaderboardRegisterDTO) {
        LeaderboardEntity leaderboardEntity = setLeaderboardEntity(leaderboardRegisterDTO);
        LeaderboardDetailsEntity leaderboardDetailsEntity = new LeaderboardDetailsEntity();

        leaderboardDetailsEntity.setLeaderboard(leaderboardEntity);

        // LeaderboardDetailsEntity leaderboardDetailsEntity = null; //TODO: Add converter with products.

        return null;
    }


    private LeaderboardEntity setLeaderboardEntity(LeaderboardRegisterDTO leaderboardRegisterDTO) {

        ClientEntity clientEntity = isSettableClient(leaderboardRegisterDTO.getClient());
        LeaderboardEntity leaderboardEntity = new LeaderboardEntity();

        leaderboardEntity.setClient(clientEntity);
        leaderboardEntity.setName(leaderboardRegisterDTO.getName()); // It is assumed that at this point the leaderboard name is not null.

        return leaderboardEntity;
    }


    private List<LeaderboardDetailsEntity> setProducts(List<LeaderboardDetailsRegisterDTO> leaderboardDetailsRegisterDTORegisterDTO){
        List<LeaderboardDetailsEntity> leaderboardDetailsEntityList = setLeaderboardDetailsEntity(leaderboardDetailsRegisterDTORegisterDTO.ge);
        for (int index = 0; index < leaderboardDetailsRegisterDTORegisterDTO.size(); index++) {
            LeaderboardDetailsRegisterDTO leaderboardDetailsRegisterDTO = leaderboardDetailsRegisterDTORegisterDTO.get(index);
            Optional<ProductEntity> optionalProduct = productRepository
                    .findByProductIdAndBrand_BrandId(   leaderboardDetailsRegisterDTO.getProduct(),
                                                        leaderboardDetailsRegisterDTO.getBrand() );

            if (optionalProduct.isPresent()){
                leaderboardDetailsEntityList.add()
            }
        }

        return null;
    }

    private ClientEntity isSettableClient(String clientUserUsername){
        Optional<ClientEntity> optionalClient = clientRepository.findByUserUsernameAndUserDeletedIsFalse(clientUserUsername);
        if (optionalClient.isPresent()){
            return optionalClient.get();
        } throw new EntityNotFoundException("Client with username " + clientUserUsername + " not found");
    }
}
