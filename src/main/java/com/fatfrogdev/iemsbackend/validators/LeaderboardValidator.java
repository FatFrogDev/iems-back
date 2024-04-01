package com.fatfrogdev.iemsbackend.validators;

import com.fatfrogdev.iemsbackend.domain.DTOS.LeaderboardDetailsRegisterDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeaderboardValidator {

    public boolean isSavableDetails(List<LeaderboardDetailsRegisterDTO> details) {
        List<Integer> productTops = details.stream()
                .map(LeaderboardDetailsRegisterDTO::getProductTop)
                .distinct()
                .toList();

        return productTops.size() == details.size();
    }

}
