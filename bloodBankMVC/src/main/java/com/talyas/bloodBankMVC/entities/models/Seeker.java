package com.talyas.bloodBankMVC.entities.models;

import com.talyas.bloodBankMVC.entities.models.enums.EBloodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Table(name = "seekers")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Seeker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private EBloodType bloodType;
    private String medicalReport;
    private String address;
    private String contactNumber;
    @Column(name = "blood_bank_id")
    private Long bloodBankID;
}

