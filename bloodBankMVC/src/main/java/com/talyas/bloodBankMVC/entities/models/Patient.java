package com.talyas.bloodBankMVC.entities.models;

import com.talyas.bloodBankMVC.entities.models.enums.EBloodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Table(name = "patients")
//@Entity
public class Patient {
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   @Id
    private Long id;

    private String name;
//    @Enumerated(EnumType.STRING)
    EBloodType bloodType;
    private String medicalReport;
    private String address;
    private String contactNumber;
}

