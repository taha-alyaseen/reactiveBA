package com.talyas.reactiveBloodBank.entities.models;

import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Data
@Table("public.patients")
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column("id")
    Long id;

    @Column("name")
    String name;
    @Enumerated(EnumType.STRING)
    @Column("blood_type")
    EBloodType bloodType;
     @Column("medical_report")
     String medicalReport;
    @Column("address")
    String address;
    @Column("contact_number")
    String contactNumber;
}

