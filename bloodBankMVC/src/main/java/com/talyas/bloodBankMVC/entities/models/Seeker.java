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
@Table("public.seekers")
@AllArgsConstructor
@NoArgsConstructor
public class Seeker {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column("blood_type")
    private EBloodType bloodType;
    @Column("medical_report")
    private String medicalReport;
    @Column("address")
    private String address;
    @Column("contact_number")
    private String contactNumber;
    @Column("blood_bank_id")
    private Long bloodBankID;
}

