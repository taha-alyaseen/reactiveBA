package com.talyas.reactiveBloodBank.entities.dtos;

import com.talyas.reactiveBloodBank.entities.models.BloodBag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListBloodBagsDTO {
    int totalNumber;
    List<BloodBagDTO> listOfABNegativ;
    List<BloodBagDTO> listOfABPositiv;
    List<BloodBagDTO> listOfANegative;
    List<BloodBagDTO> listOfAPositive;
    List<BloodBagDTO> listOfBNegative;
    List<BloodBagDTO> listOfBPositive;
    List<BloodBagDTO> listOfONegative;
    List<BloodBagDTO> listOfOPositive;
}
