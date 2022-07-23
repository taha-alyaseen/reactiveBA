package com.talyas.reactiveBloodBank.entities.dtos;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.talyas.reactiveBloodBank.entities.models.Donor;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@Builder
@NoArgsConstructor
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

