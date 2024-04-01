package com.fatfrogdev.iemsbackend.domain.DTOS;

import com.fatfrogdev.iemsbackend.validators.LeaderboardValidator;
import lombok.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class LeaderboardRegisterDTO {

    private final LeaderboardValidator leaderboardValidator;

    private String name;

    private String client;

    private List<LeaderboardDetailsRegisterDTO> details;

    public void setDetails(List<LeaderboardDetailsRegisterDTO> details) {
        if (leaderboardValidator.isSavableDetails(details)){
            this.details = details;
        } else throw  new IllegalArgumentException("Each product top must be unique");
    }
}

