package com.talyas.reactiveBloodBank.entities.models;


import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;



@Data
@Table("donors")
@AllArgsConstructor
@NoArgsConstructor
public class Donor {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    String name;
    @Enumerated(EnumType.STRING)
    EBloodType bloodType;
    String medicalReport;
    String address;
    String contactNumber;
}

