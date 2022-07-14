package com.talyas.reactiveBloodBank.entities.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BloodBankDTO{
  private Long bloodBankId; 
  private String bloodBankName;
}