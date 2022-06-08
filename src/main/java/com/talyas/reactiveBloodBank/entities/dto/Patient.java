package com.talyas.reactiveBloodBank.entities.dto;

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
    String bloodGroup;
    String medicalReport;
    String address;
    String contactNumber;
    int blood_bank_id;
}

