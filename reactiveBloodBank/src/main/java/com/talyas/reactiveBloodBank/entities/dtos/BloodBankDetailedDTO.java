package com.talyas.reactiveBloodBank.entities.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BloodBankDetailedDTO{
  private Long id; 
  private String name;
  private String address;
  private String contactNumber;
  private Long numberOfBloodBags;
}