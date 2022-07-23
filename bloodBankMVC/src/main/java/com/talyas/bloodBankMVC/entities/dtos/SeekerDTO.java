package com.talyas.bloodBankMVC.entities.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SeekerDTO {
  private Long seekerId;
  private String seekerName;
  private String seekerBloodType;
  private String seekerMedicalReport;
  private String seekerAddress;
  private String seekerContactNumber;
  private Long bloodBankID;
}
