package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.FileEntity;
import com.fatfrogdev.iemsbackend.domain.models.ReviewEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface IReviewRepository extends JpaRepository<ReviewEntity, String> {

        @Query("SELECT r FROM ReviewEntity r WHERE r.product = :product_id")
        List<ReviewEntity> findByProductId(@Param("product_id") Long productId);

        @Query("SELECT r FROM ReviewEntity r WHERE r.user = :user_id")
        List<ReviewEntity> findByUserId(@Param("user_id") Long userId);

        @Query("SELECT r FROM ReviewEntity r WHERE r.user = :user_id AND r.product = :product_id")
        Optional<ReviewEntity> findByUserIdAndProductId(@Param("user_id") Long userId, @Param("product_id") Long productId);

        @Query("SELECT r.images FROM ReviewEntity r WHERE r.reviewId = :review_id")
        Optional<Set<FileEntity>> findImagesByReviewId(@Param("review_id")String reviewId);

        @Transactional
        Optional<ReviewEntity> findByReviewId(String reviewId);
}