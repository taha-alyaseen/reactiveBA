package com.talyas.bloodBankMVC.entities.models;


import com.talyas.bloodBankMVC.entities.models.enums.EBloodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Table(name = "donors")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Donor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    String name;
    @Enumerated(EnumType.STRING)
    private EBloodType bloodType;
    private String medicalReport;
    private String address;
    private String contactNumber;
    @Column(name = "blood_bank_id")
    private Long bloodBankID;
}

