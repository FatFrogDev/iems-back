package com.fatfrogdev.iemsbackend.validators;

import com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard.LeaderboardDetailsRegisterDTO;
import org.springframework.stereotype.Component;
import com.fatfrogdev.iemsbackend.domain.models.LeaderboardEntity;

import java.util.List;

/**
 * This class allows validator methods required for {@link LeaderboardEntity} Class.
 */
@Component
public class LeaderboardValidator {


    /**
     * States if a List of {@link LeaderboardDetailsRegisterDTO} pass all the logical validations required for this object to be savable.
     * @param details the details
     * @return the boolean
     */
    public boolean isSavableDetails(List<LeaderboardDetailsRegisterDTO> details) {
        List <Integer> productTops = details.stream().map(LeaderboardDetailsRegisterDTO::getProductTop).toList();
        return isValidProductTop(productTops) && areValidQualityQuantityList(details);
    }

    /**
     * States if a List of Strings are valid to be saved or not into a DTO.
     *  @param details List of {@link LeaderboardDetailsRegisterDTO}. Used to get all the Strings to be compared.
     * @return Weather the list of Strings match a regex or not.
     */
    private boolean areValidQualityQuantityList(List<LeaderboardDetailsRegisterDTO> details){
        List<String> qualityQuantityList = details.stream().map(LeaderboardDetailsRegisterDTO::getSubBassQualityQuantity).toList();
                qualityQuantityList.addAll(details.stream().map(LeaderboardDetailsRegisterDTO::getBassQualityQuantity).toList());
                qualityQuantityList.addAll(details.stream().map(LeaderboardDetailsRegisterDTO::getMediumBassQualityQuantity).toList());
                qualityQuantityList.addAll(details.stream().map(LeaderboardDetailsRegisterDTO::getMidRangeQualityQuantity).toList());
                qualityQuantityList.addAll(details.stream().map(LeaderboardDetailsRegisterDTO::getTrebleQualityQuantity).toList());
        return isValidQualityQuantityList(qualityQuantityList);
    }

    /**
     * States if a list of String is valid to be saved or not into a DTO.
     * It is valid if the whole list matches with a regex.
     * @param qualityQuantityList List of String to be evaluated.
     * @return Weather the list of String is able to get saved or not.
     */
    public boolean isValidQualityQuantityList(List<String> qualityQuantityList){
        if  (qualityQuantityList.stream()
                .filter(this::validateQualityQuantityRegex)
                .count() == qualityQuantityList.size()
        )
                return true;
        else throw new IllegalArgumentException("The quality/quantity fields must match with (\"[0-9] or 10 \" + \"/\" + \"[0-9] or 10\")");
        }

    /**
     * States if a list of Integer is valid to be saved or not through validating the whole List of numbers and can be saved in the LeaderboardDetailsRegisterDTO List.
     *
     * @param productTopsList List of Integer containing the products tops to be evaluated.
     * @return Weather the list of Integer is able to get saved or not.
     */
    public boolean isValidProductTop(List<Integer> productTopsList){
        // Return true if the product tops are into the 1 to 50 number range and are all different, otherwise, return false.
        List<Integer> productTops = productTopsList.stream().filter(productTop -> productTop >0 && productTop <=50).toList();
        if (productTops.size() == productTopsList.size()) {

            productTops = productTops.stream()
                    .distinct()
                    .toList();
            return productTops.size() == productTopsList.size();

        } throw new IllegalArgumentException("Each product top must be unique");
    }

    public boolean validateQualityQuantityRegex(String qualityQuantity){
        return qualityQuantity.matches("^([0-9]|10)/([0-9]|10)$");
    }
}
