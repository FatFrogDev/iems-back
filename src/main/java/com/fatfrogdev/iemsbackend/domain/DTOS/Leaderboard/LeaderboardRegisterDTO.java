package com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard;

import com.fatfrogdev.iemsbackend.validators.LeaderboardValidator;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class LeaderboardRegisterDTO {

    private final LeaderboardValidator leaderboardValidator;

    private String leaderboardName;

    private String user;

    private List<LeaderboardDetailsRegisterDTO> leaderboardDetails;

    public void setLeaderboardDetails(List<LeaderboardDetailsRegisterDTO> leaderboardDetails) {
        if (leaderboardValidator.isSavableDetails(leaderboardDetails)){
            this.leaderboardDetails = leaderboardDetails;
        } else throw  new IllegalArgumentException("Each product top must be unique");
    }
}

