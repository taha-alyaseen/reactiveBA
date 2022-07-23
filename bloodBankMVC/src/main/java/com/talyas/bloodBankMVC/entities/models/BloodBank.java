package com.talyas.bloodBankMVC.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "blood_banks")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BloodBank {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String name;
  String address;
  String contactNumber;
}
