package com.talyas.reactiveBloodBank.entities.models;

import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    EBloodType bloodType;
    String medicalReport;
    String address;
    String contactNumber;
    int blood_bank_id;
}

