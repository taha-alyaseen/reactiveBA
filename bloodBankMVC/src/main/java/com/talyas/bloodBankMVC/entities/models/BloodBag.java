package com.talyas.reactiveBloodBank.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;

import java.time.LocalDate;

@Data
@Table("public.blood_bags")
@AllArgsConstructor
@NoArgsConstructor
public class BloodBag {
  @Column("id")
  @Id
  Long id;
  @Enumerated(EnumType.STRING)
  @Column("blood_type")
  EBloodType bloodType;
  @Column("time_of_recieving")
  String timeOfRecieving;
  @Column("donor_id")
  Long donorID;
  @Column("blood_banks_id")
  Long bloodBankId;
}
