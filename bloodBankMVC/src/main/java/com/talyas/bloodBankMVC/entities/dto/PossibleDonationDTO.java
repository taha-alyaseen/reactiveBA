package com.talyas.bloodBankMVC.entities.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.talyas.bloodBankMVC.entities.models.Donor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PossibleDonationDTO {
    private Long id;
    private String patientName;
    private String patientsBloodTyp;
    private String patientsMedicalReport;
    private String patientsAddress;
    private String patientsContactNumber;
    private List<Donor> possibleDonors;
}

