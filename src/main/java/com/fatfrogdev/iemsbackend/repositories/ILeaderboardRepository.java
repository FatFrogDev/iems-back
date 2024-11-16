package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILeaderboardRepository extends JpaRepository<LeaderboardEntity, String> {

    @Query("SELECT product.productId, product.name, product.brand.brandId, " +
            "lbd_dtls.bassQualityQuantity, lbd_dtls.buildQuality, lbd_dtls.cableQuality, lbd_dtls.comfort, lbd_dtls.imagePrecision, lbd_dtls.isBassHead, " +
            "lbd_dtls.isFunny, lbd_dtls.mediumBassQualityQuantity, lbd_dtls.midRangeQualityQuantity, lbd_dtls.monitoringLiveStudio,lbd_dtls.productTop, "+
            "lbd_dtls.sibilanceControl, lbd_dtls.soundStageAmplitude, lbd_dtls.subBassQualityQuantity, lbd_dtls.videoGamesPerformance "+
            "from LeaderboardDetailsEntity lbd_dtls " +
            "INNER JOIN LeaderboardEntity lbd ON lbd_dtls.leaderboard.leaderboardId = lbd.leaderboardId " +
            "INNER JOIN ProductEntity product ON lbd_dtls.product.productId = product.productId " +
            "WHERE lbd_dtls.leaderboard.leaderboardId = :in_leaderboard_id " +
            "ORDER BY CASE  WHEN :in_custom_order = 'asc' " +
            "THEN lbd_dtls.productTop " +
            "END ASC, CASE WHEN :in_custom_order = 'desc'" +
            "THEN lbd_dtls.productTop " +
            "END DESC")
    List<Object[]> findLeaderboardDetailsByIdAndOrder(
            @Param("in_leaderboard_id") String leaderboardId,
            @Param("in_custom_order") String customOrder
    );
}
