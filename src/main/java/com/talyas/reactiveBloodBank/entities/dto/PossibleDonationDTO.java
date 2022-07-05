package com.talyas.reactiveBloodBank.entities.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.talyas.reactiveBloodBank.entities.models.Donor;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PossibleDonationDTO {
    private int id;
    private String patientName;
    private String patientsBloodTyp;
    private String patientsMedicalReport;
    private String patientsAddress;
    private String patientsContactNumber;
    private List<Donor> possibleDonors;
}

