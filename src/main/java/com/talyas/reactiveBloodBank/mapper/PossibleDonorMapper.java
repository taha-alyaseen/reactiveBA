package com.talyas.reactiveBloodBank.mapper;

import com.talyas.reactiveBloodBank.entities.dto.PossibleDonationDTO;
import com.talyas.reactiveBloodBank.entities.models.Donor;
import com.talyas.reactiveBloodBank.entities.models.Patient;
import com.talyas.reactiveBloodBank.router.PossibleDonationRoute;
import org.mapstruct.Mapper;
import reactor.core.publisher.Flux;

import java.util.List;


public class PossibleDonorMapper {
    public static PossibleDonationDTO toPossibleDonationDTO(Patient patient, Flux<Donor> donors) {
        return new PossibleDonationDTO(patient.getId(), patient.getName(),patient.getBloodType().toString(), patient.getMedicalReport(), patient.getAddress(),patient.getContactNumber(), donors);
    }
}
