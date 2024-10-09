package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.UserConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.Client.UserRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Client.UserViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.UserEntity;
import com.fatfrogdev.iemsbackend.exceptions.WrongArgumentsException;
import com.fatfrogdev.iemsbackend.exceptions.user.UserIsActiveException;
import com.fatfrogdev.iemsbackend.exceptions.user.UserNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.user.UserIsInactiveException;
import com.fatfrogdev.iemsbackend.repositories.IUserRepository;
import com.fatfrogdev.iemsbackend.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    private final UserConverter userConverter;

    @Override
    public UserViewDTO save(UserRegisterDTO personDTO) { // TODO: Add validations for user already registered and deleted user. && update.
        UserEntity userEntity = userConverter.registerDtoToEntity(personDTO);
        return userConverter
                .entityToViewDto(userRepository.save(userEntity));
    }

    @Override
    public UserViewDTO findByUserUsername(String username) {
        if (username.length() < 3 || !username.matches("^[a-z0-9]*$"))
            throw new WrongArgumentsException("Error: Username must be alphanumeric and have at least 3 characters");

        Optional<UserEntity> optUserEntity = userRepository.findByUsernameAndActiveIsTrue(username);
                if (optUserEntity.isPresent())
                    return userConverter.entityToViewDto(optUserEntity.get());
                else
                    throw new UserNotFoundException(String.format("Error: User with %s username not found", username));
    }

    @Override
    public void activateOrDeactivateByUsername(String username, String action) {
        UserEntity optUserEntity = userRepository.findByUsername(username)
                .orElseThrow(()-> new UserNotFoundException(String.format("Error: User with username %s not found", username)));

        boolean userIsActive = optUserEntity.isActive();

        if (action.equals("activate")) {
            if (!userIsActive)
                userRepository.activateByUserId(optUserEntity.getUserId());
            else
                throw new UserIsActiveException("Error: User is already active");
        }
        if (action.equals("deactivate")) {
            if (userIsActive)
                userRepository.deactivateByUserId(optUserEntity.getUserId());
            else
                throw new UserIsInactiveException("Error: User was already inactivated.");
        }
    }
}