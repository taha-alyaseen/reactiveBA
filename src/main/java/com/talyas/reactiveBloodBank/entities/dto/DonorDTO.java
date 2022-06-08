package com.talyas.reactiveBloodBank.entities.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.io.Serializable;

public class DonorDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    String bloodGroup;
    String medicalReport;
    String address;
    int blood_bank_id;
    String contactNumber;


}

