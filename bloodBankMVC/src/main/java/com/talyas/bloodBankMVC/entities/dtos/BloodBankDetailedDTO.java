package com.talyas.bloodBankMVC.entities.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BloodBankDetailedDTO{
  private Long id; 
  private String name;
  private String address;
  private String contactNumber;
  private int numberOfBloodBags;
}