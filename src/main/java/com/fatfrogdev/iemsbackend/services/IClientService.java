package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.ClientRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.ClientViewDTO;

public interface IClientService {
    ClientViewDTO save(ClientRegisterDTO personDTO);

    ClientViewDTO findByUserUsername(String username);

    void deleteByUsername(String username);

    boolean userIsAlreadyDeleted(String userId);
}
