package com.talyas.reactiveBloodBank.handler;

import com.talyas.reactiveBloodBank.entities.dto.PossibleDonationDTO;
import com.talyas.reactiveBloodBank.entities.models.Donor;
import com.talyas.reactiveBloodBank.entities.models.Patient;
import com.talyas.reactiveBloodBank.repositories.DonorRepository;
import com.talyas.reactiveBloodBank.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class PossibleDonationHandler {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DonorRepository donorRepository;

    public Mono<ServerResponse> listAllPossibleDonations(ServerRequest request) {
        Flux<Patient> patientFlux = patientRepository.findAll();
        return ServerResponse.ok()
                .body(patientFlux.flatMap(
                        patient -> Mono.just(patient)
                                .map(patientMono -> {
                                    Flux<Donor> possibleDonors = donorRepository.findAllByBloodType(patientMono.getBloodType());
                                    return PossibleDonorMapper.toPossibleDonationDTO(patientMono, possibleDonors);
                                }).flatMap(a -> a)
                                .subscribeOn(Schedulers.parallel())
                ), PossibleDonationDTO.class);
    }

    public Mono<ServerResponse> getPossibleDonationById(ServerRequest request, String id) {
        Mono<Patient> patientMono = patientRepository.findById(Integer.valueOf(id));
        return ServerResponse.ok()
                .body(patientMono.map(x -> {
                            Flux<Donor> possibleDonors = donorRepository.findAllByBloodType(x.getBloodType());
                            return PossibleDonorMapper.toPossibleDonationDTO(x, possibleDonors);
                        }
                ).flatMap(x -> x)
                        , PossibleDonationDTO.class);
    }

}
