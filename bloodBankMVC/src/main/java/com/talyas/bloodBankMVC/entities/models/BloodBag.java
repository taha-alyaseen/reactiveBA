package com.talyas.bloodBankMVC.entities.models;

import com.talyas.bloodBankMVC.entities.models.enums.EBloodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blood_bags")
@Entity
public class BloodBag {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @Enumerated(EnumType.STRING)
  EBloodType bloodType;
  String timeOfRecieving;
  @Column(name = "donor_id")
  Long donorID;
  @Column(name = "blood_bank_id")
  Long bloodBankId;
}
