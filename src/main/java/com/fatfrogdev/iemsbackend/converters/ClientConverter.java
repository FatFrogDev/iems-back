package com.fatfrogdev.iemsbackend.converters;

import com.fatfrogdev.iemsbackend.domain.DTOS.Client.ClientRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Client.ClientViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.ClientEntity;
import com.fatfrogdev.iemsbackend.domain.models.UserEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import static com.fatfrogdev.iemsbackend.converters.BaseConverter.baseMapper;

@Component
@Log4j2
public class ClientConverter {

    public ClientEntity viewDtoToEntity(ClientViewDTO clientViewDTO) {
        try {
            return baseMapper().map(clientViewDTO, ClientEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ClientEntity registerDtoToEntity(ClientRegisterDTO registerDTO) {
        try
        {
            ClientEntity  clientConverted = baseMapper().map(registerDTO, ClientEntity.class);
            UserEntity userEntity = new UserEntity(registerDTO.getEmail(),
                    registerDTO.getPassword(),
                    registerDTO.getUsername());
            clientConverted.setUser(userEntity);
            System.out.println(clientConverted);
            return  clientConverted;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ClientViewDTO entityToViewDto(ClientEntity clientEntity) {
        try {
            ClientViewDTO clientViewDTO = baseMapper().map(clientEntity, ClientViewDTO.class);
            clientViewDTO.setEmail(clientEntity.getUser().getEmail());
            clientViewDTO.setUsername(clientEntity.getUser().getUsername());
            return clientViewDTO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
