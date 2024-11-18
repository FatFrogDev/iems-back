package com.fatfrogdev.iemsbackend.validators;

import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsRegisterDTO;
import com.fatfrogdev.iemsbackend.exceptions.WrongArgumentsException;
import org.springframework.stereotype.Component;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows validator methods required for {@link LeaderboardEntity} Class.
 */
@Component
public class LeaderboardValidator {
    
    /**
     * States if a List of {@link LeaderboardDetailsRegisterDTO} pass all the logical validations required for this object to be savable.
     * @param details the details.
     */
    public void validateLeaderboardDetailsList(List<LeaderboardDetailsRegisterDTO> details) {
        List <Integer> productTops = details.stream().map(LeaderboardDetailsRegisterDTO::getProductTop).toList();
        validateProductTops(productTops);
        isValidQualityQuantityList(details);
    }

    /**
     * States if a List of Strings are valid to be saved or not into a DTO.
     *  @param details List of {@link LeaderboardDetailsRegisterDTO}. Used to get all the Strings to be compared.
     */
    private void isValidQualityQuantityList(List<LeaderboardDetailsRegisterDTO> details){
        List<String> qualityQuantityList = new ArrayList<>(details.stream().map(LeaderboardDetailsRegisterDTO::getSubBassQualityQuantity).toList());
                qualityQuantityList.addAll(details.stream().map(LeaderboardDetailsRegisterDTO::getBassQualityQuantity).toList());
                qualityQuantityList.addAll(details.stream().map(LeaderboardDetailsRegisterDTO::getMediumBassQualityQuantity).toList());
                qualityQuantityList.addAll(details.stream().map(LeaderboardDetailsRegisterDTO::getMidRangeQualityQuantity).toList());
                qualityQuantityList.addAll(details.stream().map(LeaderboardDetailsRegisterDTO::getTrebleQualityQuantity).toList());
        validateQualityQuantityList(qualityQuantityList);
    }

    /**
     * States if a list of String is valid to be saved or not into a DTO.
     * It is valid if the whole list matches with a regex.
     * @param qualityQuantityList List of String to be evaluated.
     */
    public void validateQualityQuantityList(List<String> qualityQuantityList){
        boolean isValidList = qualityQuantityList.stream()
            .filter(this::validateQualityQuantityRegex)
            .count() == qualityQuantityList.size();
        
        if (!isValidList)
            throw new WrongArgumentsException("The quality/quantity fields must match with (\"[0-9] or 10 \" + \"/\" + \"[0-9] or 10\")");
        }

    /**
     * States if a list of Integer is valid to be saved or not through validating the whole List of numbers and can be saved in the LeaderboardDetailsRegisterDTO List.
     *
     * @param productTopsList List of Integer containing the products tops to be evaluated.
     */
    public void validateProductTops(List<Integer> productTopsList){
        // Evaluates if the product tops are into the 1 to 50 number range and are all different.
        List<Integer> productTopsFiltered = productTopsList.stream().filter(productTop -> productTop >0 && productTop <=50).toList();
        if (productTopsFiltered.size() == productTopsList.size()) {
            productTopsFiltered = productTopsFiltered.stream()
                    .distinct()
                    .toList();
            if (!(productTopsFiltered.size() == productTopsList.size()))
                throw new WrongArgumentsException("Each product top must be unique");
        } else 
            throw new WrongArgumentsException("Product tops must be between 1 and 50");
    }

   private boolean validateQualityQuantityRegex(String qualityQuantity){
        return qualityQuantity.matches("^([0-9]|10)/([0-9]|10)$");
    }
}
