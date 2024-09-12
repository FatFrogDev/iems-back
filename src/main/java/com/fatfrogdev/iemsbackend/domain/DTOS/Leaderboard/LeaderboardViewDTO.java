package com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardViewDTO {

    private String leaderboardId;
    private String leaderboardName;
    private String clientUsername;
    private List<LeaderboardDetailsViewDTO> leaderboardDetails;

}
