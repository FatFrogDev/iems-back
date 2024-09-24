package com.fatfrogdev.iemsbackend.services.impl;

import ch.qos.logback.core.net.server.Client;
import com.fatfrogdev.iemsbackend.converters.LeaderboardConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.ClientEntity;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;
import com.fatfrogdev.iemsbackend.domain.models.UserEntity;
import com.fatfrogdev.iemsbackend.exceptions.client.ClientNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.leaderboard.LeaderboardNotFoundException;
import com.fatfrogdev.iemsbackend.repositories.IClientRepository;
import com.fatfrogdev.iemsbackend.repositories.ILeaderboardRepository;
import com.fatfrogdev.iemsbackend.services.ILeaderboardDetailsService;
import com.fatfrogdev.iemsbackend.services.ILeaderboardService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return findById(leaderboardEntity.getLeaderboardId(), null);
    }

    @Override
    public LeaderboardViewDTO findById(String LeaderboardId, String order) { // TODO: Check if both exists
        order = order == null ? "asc" : order; // TODO: validate word is "asc" or "desc" properly. // TODO: validate word is "asc" or "desc" properly.
        boolean leaderboardExists = leaderboardRepository.existsById(LeaderboardId);
        
        if (!leaderboardExists)
            throw new LeaderboardNotFoundException(String.format("Leaderboard with id %s not found", LeaderboardId));

        LeaderboardEntity leaderboardEntity = leaderboardRepository.findById(LeaderboardId)
                .orElseThrow(() -> new LeaderboardNotFoundException(String.format("Leaderboard with id %s not found", LeaderboardId)));

            return LeaderboardViewDTO.builder()
                    .leaderboardId(LeaderboardId)
                    .leaderboardName(leaderboardEntity.getName())
                    .clientUsername(leaderboardEntity.getClient().getUser().getUsername())
                    .leaderboardDetails(
                            leaderboardDetailsService.findById(LeaderboardId, order)
                    ).build();
    }


    private LeaderboardEntity saveLeaderboardEntity(LeaderboardRegisterDTO leaderboardRegisterDTO) { //TODO? Refactor to add personalized exception

        String optClientId = findClientIdByUsername(leaderboardRegisterDTO.getClientUsername());
        String optUserId = findUserIdByUsername(leaderboardRegisterDTO.getClientUsername());

        ClientEntity clientEntity = new ClientEntity(optClientId,
                                        new UserEntity(optUserId,
                                        leaderboardRegisterDTO.getClientUsername()));

        LeaderboardEntity leaderboardEntity = leaderboardConverter.registerDtoToLeaderboardEntity(leaderboardRegisterDTO, clientEntity);
            return leaderboardRepository.save(leaderboardEntity);
    }

    private String findClientIdByUsername(String clientUsername) {
        return clientRepository.findClientIdByUserUsername(clientUsername)
                .orElseThrow(()->new ClientNotFoundException(String.format("Client with username %s not found", clientUsername)));
    }

    private String findUserIdByUsername(String clientUsername) {
        return clientRepository.findUserIdByUserUsername(clientUsername)
                .orElseThrow(()->new ClientNotFoundException(String.format("Client with username %s not found", clientUsername)));
    }

}