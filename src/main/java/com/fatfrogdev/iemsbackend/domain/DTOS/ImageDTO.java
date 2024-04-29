package com.fatfrogdev.iemsbackend.domain.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
public class ImageDTO {

    private String imageTittle;

    private String clientId;

    private String productId;

    private Integer reviewNumber;

    private MultipartFile image;

}
