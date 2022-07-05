package com.talyas.reactiveBloodBank.handler;

import com.talyas.reactiveBloodBank.entities.dto.PossibleDonationDTO;
import com.talyas.reactiveBloodBank.entities.models.Donor;
import com.talyas.reactiveBloodBank.entities.models.Patient;
import com.talyas.reactiveBloodBank.router.PossibleDonationRoute;
import org.mapstruct.Mapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


public class PossibleDonorMapper {
    public static Mono<PossibleDonationDTO> toPossibleDonationDTO(Patient patient, Flux<Donor> donors) {
        return donors.collectList().map(x -> {
            List<Donor> donorList = new ArrayList<Donor>();
            donorList.addAll(x);
                return new PossibleDonationDTO(
                        patient.getId(),
                        patient.getName(),
                        patient.getBloodType().toString(),
                        patient.getMedicalReport(),
                        patient.getAddress(),
                        patient.getContactNumber(),
                        donorList);
    });
    }
}
