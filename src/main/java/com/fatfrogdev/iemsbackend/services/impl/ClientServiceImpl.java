package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.ClientConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.Client.ClientRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Client.ClientViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.ClientEntity;
import com.fatfrogdev.iemsbackend.domain.models.UserEntity;
import com.fatfrogdev.iemsbackend.exceptions.WrongArgumentsException;
import com.fatfrogdev.iemsbackend.exceptions.client.ClientIsAlreadyActiveException;
import com.fatfrogdev.iemsbackend.exceptions.client.ClientNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.client.ClientWasAlreadyDeactivatedException;
import com.fatfrogdev.iemsbackend.repositories.IClientRepository;
import com.fatfrogdev.iemsbackend.repositories.IUserRepository;
import com.fatfrogdev.iemsbackend.services.IClientService;
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
    public ClientViewDTO save(ClientRegisterDTO personDTO) { // TODO: Add validations for client already registered and deleted user. && update.
        ClientEntity clientEntity = clientConverter.registerDtoToEntity(personDTO);
        return clientConverter
                .entityToViewDto(clientRepository.save(clientEntity));
    }

    @Override
    public ClientViewDTO findByUserUsername(String username) {
        if (username.length() < 3 || !username.matches("^[a-zA-Z0-9]*$"))
            throw new WrongArgumentsException("Error: Username must be alphanumeric and have at least 3 characters");

        Optional<ClientEntity> optClientEntity = clientRepository.findByUserUsernameAndUserDeletedIsFalse(username);
                if (optClientEntity.isPresent())
                    return clientConverter.entityToViewDto(optClientEntity.get());
                else
                    throw new ClientNotFoundException(String.format("Error: Client with %s username not found", username));
    }

    @Override
    public void activateOrDeactivateByUsername(String username, String action) {
        Optional<UserEntity> optUserEntity = userRepository.findByUsername(username);
        if(optUserEntity.isEmpty())
             throw new ClientNotFoundException(String.format("Error: Client with %s username not found", username));
        else {
            boolean userIsDeleted = optUserEntity.get().isDeleted();

            if (action.equals("deactivate")) {
                if (!userIsDeleted)
                    userRepository.deleteByUserId(optUserEntity.get().getUserId());
                else
                    throw new ClientWasAlreadyDeactivatedException("Error: Client was already deleted");
            }
            if (action.equals("activate")) {
                if (userIsDeleted) {
                    System.out.println("user" + optUserEntity.get().getUsername() + "activated");
                    userRepository.activateByUserId(optUserEntity.get().getUserId());
                }
                else
                    throw new ClientIsAlreadyActiveException("Error: User is already active");
            }
        }
    }

}