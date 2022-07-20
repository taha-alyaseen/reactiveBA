package com.talyas.reactiveBloodBank.entities.dtos;

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
  Long seekerId;
  String seekerName;
  String seekerBloodType;
  String seekerMedicalReport;
  String seekerAddress;
  String seekerContactNumber;
  Long bloodBankID;
}
