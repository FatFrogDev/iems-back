package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.LeaderboardConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.ClientEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardDetailsEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import com.fatfrogdev.iemsbackend.repositories.IClientRepository;
import com.fatfrogdev.iemsbackend.repositories.ILeaderboardDetailsRepository;
import com.fatfrogdev.iemsbackend.repositories.ILeaderboardRepository;
import com.fatfrogdev.iemsbackend.repositories.IProductRepository;
import com.fatfrogdev.iemsbackend.services.ILeaderboardService;
import com.fatfrogdev.iemsbackend.validators.LeaderboardValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class LeaderboardServiceImpl implements ILeaderboardService {

    private final ILeaderboardRepository leaderboardRepository;

    private final ILeaderboardDetailsRepository leaderboardDetailsRepository;

    private final LeaderboardValidator leaderboardValidator;

    private final IProductRepository productRepository;

    private final IClientRepository clientRepository;

    private final LeaderboardConverter leaderboardConverter;


    @Override
    public List<LeaderboardViewDTO> saveLeaderboard(LeaderboardRegisterDTO leaderboardRegisterDTO) {
        LeaderboardEntity leaderboardEntity = saveLeaderboardEntity(leaderboardRegisterDTO);
        saveLeaderboardDetailsCollection(leaderboardRegisterDTO, leaderboardEntity);
        System.out.println("Leaderboard saved successfully" + leaderboardEntity);
        return findById(leaderboardEntity.getLeaderboardId(), null);
    }

    @Override
    public void saveLeaderboardDetailsCollection(LeaderboardRegisterDTO leaderboardRegisterDTO, LeaderboardEntity leaderboardEntity){

        List<LeaderboardDetailsEntity> leaderboardDetailsEntityList = new ArrayList<>();

        for (int index = 0; index < leaderboardRegisterDTO.getLeaderboardDetails().size(); index++) {


            ProductEntity productEntity = findProductEntityByNameAndBrand(
                    leaderboardRegisterDTO.getLeaderboardDetails().get(index).getProduct(),
                    leaderboardRegisterDTO.getLeaderboardDetails().get(index).getBrand()
            );


            leaderboardDetailsEntityList.add(
                            clusterLeaderboardDetailsEntity(
                                    leaderboardRegisterDTO.getLeaderboardDetails().get(index),
                                    leaderboardEntity,
                                    leaderboardEntity.getClient(),
                                    productEntity
                    )
            );
        }
        //TODO:  validations to assert that list is not null.
        if (leaderboardDetailsEntityList.size()==leaderboardRegisterDTO.getLeaderboardDetails().size()) {
            System.out.println("saving all details entities");
            leaderboardDetailsRepository.saveAll(leaderboardDetailsEntityList);
        }
        else throw new IllegalArgumentException("Leaderboard details list is not the same size as the DTO list");
    }

    @Override
    public List<LeaderboardViewDTO> findById(String leaderboardId, String customOrder) {
        customOrder = customOrder== null ? "asc" : customOrder;
        return leaderboardRepository.findLeaderboardByIdAndOrder(leaderboardId, customOrder).orElseThrow(EntityNotFoundException::new);
    }

    private LeaderboardDetailsEntity clusterLeaderboardDetailsEntity(LeaderboardDetailsRegisterDTO leaderboardDetailsRegisterDTO, LeaderboardEntity leaderboardEntity, ClientEntity clientEntity, ProductEntity productEntity) {
        return leaderboardConverter.DetailsRegisterDtoToDetailsEntity(leaderboardDetailsRegisterDTO, leaderboardEntity, clientEntity, productEntity);
    }

    private LeaderboardEntity saveLeaderboardEntity(LeaderboardRegisterDTO leaderboardRegisterDTO) { //TODO? Refactor to add personalized exception
        ClientEntity clientEntity = findClientEntityByUserUsername(leaderboardRegisterDTO.getClient());
        LeaderboardEntity leaderboardEntity = leaderboardConverter.registerDtoToLeaderboardEntity(leaderboardRegisterDTO, clientEntity);
        return leaderboardRepository.save(leaderboardEntity);
    }



    private ClientEntity findClientEntityByUserUsername(String clientUsername) {
        return clientRepository.findByUserUsernameAndUserDeletedIsFalse(clientUsername).orElseThrow(EntityNotFoundException::new);
    }

    private ProductEntity findProductEntityByNameAndBrand(String productName, String productBrand) {
        System.out.println("Finding: " + productBrand + " " + productName + " " + "...");
        return productRepository.findByNameAndBrand_BrandId(productName,productBrand).orElseThrow(EntityNotFoundException::new);
    }
}