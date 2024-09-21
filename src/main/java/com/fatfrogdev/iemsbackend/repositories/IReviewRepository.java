package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.FileEntity;
import com.fatfrogdev.iemsbackend.domain.models.ReviewEntity;
import com.fatfrogdev.iemsbackend.domain.models.ReviewId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface IReviewRepository extends JpaRepository<ReviewEntity, ReviewId> {

        @Query("SELECT r FROM ReviewEntity r WHERE r.reviewId.product.productId = :productId")
        List<ReviewEntity> findByProductId(@Param("productId") Long productId);

        @Query("SELECT r FROM ReviewEntity r WHERE r.reviewId.client.clientId = :clientId")
        List<ReviewEntity> findByClientId(@Param("clientId") Long clientId);

        @Query("SELECT r FROM ReviewEntity r WHERE r.reviewId.client.clientId = :clientId AND r.reviewId.product.productId = :productId")
        Optional<ReviewEntity> findByClientIdAndProductId(@Param("clientId") Long clientId, @Param("productId") Long productId);

        @Query("SELECT r.images FROM ReviewEntity r WHERE r.reviewId = :reviewId")
        Optional<Set<FileEntity>> findImagesByReviewId(ReviewId reviewId);

        @Transactional
        Optional<ReviewEntity> findByReviewId(ReviewId reviewId);
}