package com.talyas.bloodBankMVC.entities.dtos;

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
