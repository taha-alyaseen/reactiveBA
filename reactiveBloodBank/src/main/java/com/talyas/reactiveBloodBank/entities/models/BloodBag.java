package com.talyas.reactiveBloodBank.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;

@Data
@Table("public.donors")
@AllArgsConstructor
@NoArgsConstructor
public class BloodBag {
  @Id
  Long id;
  @Enumerated(EnumType.STRING)
  EBloodType bloodType;
  Date timeOfRecieving;
  Long donorID;
  Long bloodBankId;
}
