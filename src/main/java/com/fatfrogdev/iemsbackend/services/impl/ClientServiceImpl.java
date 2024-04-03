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
            Optional<ClientEntity> optionalClientEntity = clientRepository.findByUserUsernameAndUserDeletedIsFalse(username);
                if (optionalClientEntity.isPresent()){
                    return clientConverter.entityToViewDto(optionalClientEntity.get());
                }throw new EntityNotFoundException("User not found");
        }throw new IllegalArgumentException("Invalid username format (Alphanumeric only)");
    }


    @Override
    public void deleteByUsername(String username) {
        if (username!=null){
            UserEntity optionalUserEntity = userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
                if (!userIsAlreadyDeleted(optionalUserEntity.getUserId())){                // TODO: Add generic validation for id null and user is already deleted
                    userRepository.deleteByUserId(optionalUserEntity.getUserId());
                } else throw new IllegalArgumentException("User is already deleted");
        } else throw new IllegalArgumentException("Error getting the user id");
    }

    @Override
    public boolean userIsAlreadyDeleted(String userId){
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserIdAndAndDeletedIsTrue(userId);
        return optionalUserEntity.isPresent();
    }
}
