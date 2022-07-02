package com.talyas.reactiveBloodBank.entities.models;


import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Table(name = "donor")
@AllArgsConstructor
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    EBloodType bloodType;
    String medicalReport;
    String address;
    int blood_bank_id;
    String contactNumber;



}

