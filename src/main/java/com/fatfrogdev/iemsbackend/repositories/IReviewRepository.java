package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.ReviewEntity;
import com.fatfrogdev.iemsbackend.domain.models.ReviewId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReviewRepository extends JpaRepository<ReviewEntity, ReviewId> {

    @Query("select r.reviewId.reviewNumber from ReviewEntity r where (r.reviewId.client.clientId, r.reviewId.product.productId) in ((:client_id, :product_id)) order by r.reviewId.reviewNumber desc limit 4")
    List<Integer> findReviewNumber(@Param("product_id") String product_id,
                                   @Param("client_id") String client_id);
}