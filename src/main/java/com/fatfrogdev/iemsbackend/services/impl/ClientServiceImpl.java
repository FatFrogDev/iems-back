package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.ClientConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.Client.ClientRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Client.ClientViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.ClientEntity;
import com.fatfrogdev.iemsbackend.domain.models.UserEntity;
import com.fatfrogdev.iemsbackend.repositories.IClientRepository;
import com.fatfrogdev.iemsbackend.repositories.IUserRepository;
import com.fatfrogdev.iemsbackend.services.IClientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements IClientService {

    private final IUserRepository userRepository;

    private final IClientRepository clientRepository;

    private final ClientConverter clientConverter;

    @Override
    public ClientViewDTO save(ClientRegisterDTO personDTO) {
        ClientEntity clientEntity = clientConverter.registerDtoToEntity(personDTO);
        return clientConverter
                .entityToViewDto(clientRepository.save(clientEntity));
    }

    @Override
    public ClientViewDTO findByUserUsername(String username) {
        if (username.matches("^[a-zA-Z0-9]*$")) {
            Optional<ClientEntity> optClientEntity = clientRepository.findByUserUsernameAndUserDeletedIsFalse(username);
                if (optClientEntity.isPresent()){
                    return clientConverter.entityToViewDto(optClientEntity.get());
                }throw new EntityNotFoundException("User not found");
        }throw new IllegalArgumentException("Invalid username format (Alphanumeric only)");
    }


    @Override
    public void deleteByUsername(String username) {
        if (username!=null){
            UserEntity optlUserEntity = userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
                if (!userIsAlreadyDeleted(optlUserEntity.getUserId())){                // TODO: Add generic validation for id null and user is already deleted
                    userRepository.deleteByUserId(optlUserEntity.getUserId());
                } else throw new IllegalArgumentException("User is already deleted");
        } else throw new IllegalArgumentException("Error getting the user id");
    }

    @Override
    public boolean userIsAlreadyDeleted(String userId){
        Optional<UserEntity> optUserEntity = userRepository.findByUserIdAndAndDeletedIsTrue(userId);
        return optUserEntity.isPresent();
    }
}
