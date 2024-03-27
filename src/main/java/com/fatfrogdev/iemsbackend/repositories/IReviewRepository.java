package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.ReviewEntity;
import com.fatfrogdev.iemsbackend.domain.models.ReviewId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewRepository extends JpaRepository<ReviewEntity, ReviewId> {
}
