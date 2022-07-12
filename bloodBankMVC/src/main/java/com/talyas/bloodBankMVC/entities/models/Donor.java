package com.talyas.bloodBankMVC.entities.models;


import com.talyas.bloodBankMVC.entities.models.enums.EBloodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Donor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private EBloodType bloodType;
    private String medicalReport;
    private String address;
    private String contactNumber;
}

