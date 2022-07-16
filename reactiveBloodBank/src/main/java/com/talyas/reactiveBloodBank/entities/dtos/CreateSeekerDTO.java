package com.talyas.reactiveBloodBank.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateSeekerDTO {
  String name;
  String bloodType;
  String medicalReport;
  String address;
  String contactNumber;
}
