package com.talyas.bloodBankMVC.entities.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BloodBagDTO {
    Long id;
    String bloodType;
    String timeOfRecieving;
    Long donorID;
    Long bloodBankId;
}
