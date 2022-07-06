package com.talyas.reactiveBloodBank.entities.models;

import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;


@Data
@Table("patients")
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    @Enumerated(EnumType.STRING)
    EBloodType bloodType;
    String medicalReport;
    String address;
    String contactNumber;
}

