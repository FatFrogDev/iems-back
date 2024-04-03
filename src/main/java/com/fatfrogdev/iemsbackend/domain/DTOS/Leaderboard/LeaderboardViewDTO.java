package com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard;


public interface LeaderboardViewDTO {
    String getLeaderboardId();
    String getLeaderboardName();
    String getClientUsername();
    String getProductId();
    String getProductName();
    String getProductBrand();
    String getBassQualityQuantity();
    String getBuildQuality();
    String getCableQuality();
    String getComfort();
    String getImagePrecision();
    boolean isBassHead();
    boolean isFunny();
    String getMediumBassQualityQuantity();
    String getMidRangeQualityQuantity();
    String getMonitoringLiveStudio();
    Integer getProductTop();
    String getSibilanceControl();
    String getSoundStageAmplitude();
    String getSubBassQualityQuantity();
    String getVideoGamesPerformanceM();

}
