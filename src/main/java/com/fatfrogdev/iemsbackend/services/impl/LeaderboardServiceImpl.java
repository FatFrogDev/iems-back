package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.LeaderboardConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.ClientEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;
import com.fatfrogdev.iemsbackend.repositories.IClientRepository;
import com.fatfrogdev.iemsbackend.repositories.ILeaderboardRepository;
import com.fatfrogdev.iemsbackend.services.ILeaderboardDetailsService;
import com.fatfrogdev.iemsbackend.services.ILeaderboardService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class LeaderboardServiceImpl implements ILeaderboardService {

    private final ILeaderboardRepository leaderboardRepository;

    private final ILeaderboardDetailsService leaderboardDetailsService;

    private final IClientRepository clientRepository;

    private final LeaderboardConverter leaderboardConverter;


    @Override
    public LeaderboardViewDTO saveLeaderboard(LeaderboardRegisterDTO leaderboardRegisterDTO) {
        LeaderboardEntity leaderboardEntity = saveLeaderboardEntity(leaderboardRegisterDTO);
        leaderboardDetailsService.saveLeaderboardDetailsCollection(leaderboardRegisterDTO, leaderboardEntity);
        return leaderboardDetailsService.findById(leaderboardEntity.getLeaderboardId(), null);
    }


    private LeaderboardEntity saveLeaderboardEntity(LeaderboardRegisterDTO leaderboardRegisterDTO) { //TODO? Refactor to add personalized exception

        Optional<String> optClientUsername = findClientByUsername(leaderboardRegisterDTO.getClient());

        if (optClientUsername.isPresent()) { // TODO: Add validation for client deleted not able to save a leaderboard.
            LeaderboardEntity leaderboardEntity = leaderboardConverter.registerDtoToLeaderboardEntity(leaderboardRegisterDTO, new ClientEntity(optClientUsername.get()));
            return leaderboardRepository.save(leaderboardEntity);
        }
        throw new EntityNotFoundException("Client with username " +  leaderboardRegisterDTO.getLeaderboardDetails() + " not found");
    }


    private Optional<String> findClientByUsername(String clientUsername) {
        return clientRepository.findClientEntityByClientUserUsername(clientUsername);
    }

}