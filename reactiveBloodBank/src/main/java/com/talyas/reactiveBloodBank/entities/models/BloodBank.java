package com.talyas.reactiveBloodBank.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("public.blood_banks")
@AllArgsConstructor
@NoArgsConstructor
public class BloodBank {
  @Id
  Long id;
  String name;
  String address;
  String contactNumber;
}
