package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.LeaderboardDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILeaderboardDetailsRepository extends JpaRepository<LeaderboardDetailsEntity, String> {
    LeaderboardDetailsEntity findByLeaderboardLeaderboardId(String calificatiocanTableId);
}
