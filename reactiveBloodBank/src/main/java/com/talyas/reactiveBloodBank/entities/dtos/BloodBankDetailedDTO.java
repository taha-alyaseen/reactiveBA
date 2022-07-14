package com.talyas.reactiveBloodBank.entities.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BloodBankDetailedDTO{
  private Long id; 
  private String name;
  private String address;
  private String contactNumber;
  private Long numberOFBags;
}