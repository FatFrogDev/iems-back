package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.Client.UserRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Client.UserViewDTO;

public interface IUserService {
    UserViewDTO save(UserRegisterDTO personDTO);

    UserViewDTO findByUserUsername(String username);

    void activateOrDeactivateByUsername(String username, String action);
}
