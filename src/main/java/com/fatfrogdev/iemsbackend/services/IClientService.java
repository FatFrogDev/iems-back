package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.Client.ClientRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Client.ClientViewDTO;

public interface IClientService {
    ClientViewDTO save(ClientRegisterDTO personDTO);

    ClientViewDTO findByUserUsername(String username);

    void deleteByUsername(String username);

    boolean userIsAlreadyDeleted(String userId);
}
