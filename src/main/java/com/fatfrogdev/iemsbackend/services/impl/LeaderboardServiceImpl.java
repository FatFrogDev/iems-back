package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.LeaderboardConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;
import com.fatfrogdev.iemsbackend.domain.models.UserEntity;
import com.fatfrogdev.iemsbackend.exceptions.user.UserNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.leaderboard.LeaderboardNotFoundException;
import com.fatfrogdev.iemsbackend.repositories.ILeaderboardRepository;
import com.fatfrogdev.iemsbackend.repositories.IUserRepository;
import com.fatfrogdev.iemsbackend.services.ILeaderboardDetailsService;
import com.fatfrogdev.iemsbackend.services.ILeaderboardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class LeaderboardServiceImpl implements ILeaderboardService {

    private final ILeaderboardRepository leaderboardRepository;

    private final ILeaderboardDetailsService leaderboardDetailsService;

    private final LeaderboardConverter leaderboardConverter;

    private final IUserRepository userRepository;

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
                    .userUsername(leaderboardEntity.getUser().getUsername())
                    .leaderboardDetails(
                            leaderboardDetailsService.findByLeaderboardId(LeaderboardId, order)
                    ).build();
    }


    private LeaderboardEntity saveLeaderboardEntity(LeaderboardRegisterDTO leaderboardRegisterDTO) { //TODO? Refactor to add personalized exception
        UserEntity userEntity = userRepository.findByUsernameAndActiveIsTrue(leaderboardRegisterDTO.getUser())
                .orElseThrow(()-> new UserNotFoundException(String.format("User with username %s not found.", leaderboardRegisterDTO.getUser())));

        LeaderboardEntity leaderboardEntity = leaderboardConverter
                .registerDtoToLeaderboardEntity(leaderboardRegisterDTO, userEntity);
            return leaderboardRepository.save(leaderboardEntity);
    }

}