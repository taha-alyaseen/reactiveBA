package com.talyas.reactiveBloodBank.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="blood_bank")
@AllArgsConstructor
@NoArgsConstructor
public class BloodBank {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String disease;
    String address;
    String contactNumber;
}
