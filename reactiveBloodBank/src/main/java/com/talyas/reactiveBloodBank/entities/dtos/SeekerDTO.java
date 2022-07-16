package com.talyas.reactiveBloodBank.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SeekerDTO {
  Long seekerId;
  String seekerName;
  String seekerBloodType;
  String seekerMedicalReport;
  String seekerAddress;
  String seekerContactNumber;
}
