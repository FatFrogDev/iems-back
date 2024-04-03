package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.ReviewConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.ClientEntity;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import com.fatfrogdev.iemsbackend.domain.models.ReviewEntity;
import com.fatfrogdev.iemsbackend.repositories.IClientRepository;
import com.fatfrogdev.iemsbackend.repositories.IProductRepository;
import com.fatfrogdev.iemsbackend.repositories.IReviewRepository;
import com.fatfrogdev.iemsbackend.services.IReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements IReviewService {

    private final ReviewConverter reviewConverter;

    private final IReviewRepository reviewRepository;

    private final IProductRepository productRepository;

    private final IClientRepository clientRepository;

    @Override
    public ReviewViewDTO save(ReviewRegisterDTO reviewRegisterDTO) {
        ReviewEntity reviewEntity = buildEntity(reviewRegisterDTO);
        System.out.println("ReviewEntity: " + reviewEntity);
        if (reviewEntity!=null)
            return reviewConverter.entityToViewDto(
                    reviewRepository.save(reviewEntity
                    )
            );
        else throw new RuntimeException("Error while saving the review.");
    }

    @Override
    public ReviewEntity buildEntity(ReviewRegisterDTO reviewRegisterDTO) {
        Optional<ClientEntity> client = clientRepository.findByUserUsernameAndUserDeletedIsFalse(reviewRegisterDTO.getUserId());
        Optional<ProductEntity> product = productRepository.findById(reviewRegisterDTO.getProductId());
        if(client.isPresent() && product.isPresent()){
            Integer reviewNumber = getReviewNumber(product.get().getProductId(), client.get().getClientId());
            return reviewConverter.
                    reviewRegisterDtoToEntity(reviewRegisterDTO,product.get(), client.get(), reviewNumber);
        }
        return null;
    }


    private Integer getReviewNumber(String productId, String clientId){
        List<Integer> reviewNumberFound =  reviewRepository.findReviewNumber(productId,clientId);
        if(!reviewNumberFound.isEmpty()) {
            reviewNumberFound.forEach(System.out::println);
            return  reviewNumberFound.get(0) + 1;
        }return 1;
    }
}
