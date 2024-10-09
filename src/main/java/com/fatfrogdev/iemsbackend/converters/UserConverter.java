package com.fatfrogdev.iemsbackend.converters;

import com.fatfrogdev.iemsbackend.domain.DTOS.Client.UserRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Client.UserViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.UserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import static com.fatfrogdev.iemsbackend.converters.BaseConverter.baseMapper;

@AllArgsConstructor
@Component
@Log4j2
public class UserConverter {
    public UserEntity registerDtoToEntity(UserRegisterDTO personDTO) {
        try {
            return baseMapper().map(personDTO, UserEntity.class);
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    public UserRegisterDTO entityToRegisterDto(UserEntity userEntity) {
        try {
            return baseMapper().map(userEntity, UserRegisterDTO.class);
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    public UserViewDTO entityToViewDto(UserEntity userEntity) {
        try {
            return baseMapper().map(userEntity, UserViewDTO.class);
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }
}
