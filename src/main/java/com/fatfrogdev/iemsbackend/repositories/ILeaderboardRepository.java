package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILeaderboardRepository extends JpaRepository<LeaderboardEntity, String> {

    @Query(value = "call find_leaderboard_details(:in_leaderboard_id, :in_custom_order)", nativeQuery = true)
    Optional<List<Object[]>> findLeaderboardDetailsByIdAndOrder(@Param("in_leaderboard_id") String leaderboardId,
                                                                          @Param("in_custom_order") String customOrder);
}
