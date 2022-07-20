package com.talyas.reactiveBloodBank.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BloodBagDTO {
    Long id;
    String bloodType;
    String timeOfRecieving;
    Long donorID;
    Long bloodBankId;
}
