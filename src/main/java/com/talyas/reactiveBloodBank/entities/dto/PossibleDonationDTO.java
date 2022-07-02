package com.talyas.reactiveBloodBank.entities.dto;


import com.talyas.reactiveBloodBank.entities.models.Donor;
import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import reactor.core.publisher.Flux;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
public class PossibleDonationDTO implements Serializable {    
    int id;
    String patientName;
    String patientsBloodTyp;
    String patientsMedicalReport;
    String patientsAddress;
    String patientsContactNumber;
    Flux<Donor> possibleDonors;
}

