package com.talyas.bloodBankMVC.entities.dtos;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.talyas.bloodBankMVC.entities.models.Donor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PossibleDonationDTO {
    private Long seekerId;
    private String seekerName;
    private String seekerBloodTyp;
    private String seekerMedicalReport;
    private String seekerAddress;
    private String seekerContactNumber;
    private List<DonorDTO> possibleDonors;
    private List<BloodBagDTO> availableBloodBags;
}

