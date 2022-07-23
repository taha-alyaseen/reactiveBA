package com.talyas.reactiveBloodBank.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DonorDTO {
    private Long donorId;
    private String donorName;
    private String donorBloodType;
    private String donorMedicalReport;
    private String donorAddress;
    private String donorContactNumber;
    private Long bloodBankID;
}
