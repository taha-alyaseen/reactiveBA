package com.talyas.reactiveBloodBank.entities.models;


import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Data
@Entity
@Table(name = "donor")
@AllArgsConstructor
@NoArgsConstructor
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    EBloodType bloodType;
    String medicalReport;
    String address;
    String contactNumber;
}

