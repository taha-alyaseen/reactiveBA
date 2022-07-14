package com.talyas.reactiveBloodBank.handler;

import com.talyas.reactiveBloodBank.entities.dtos.PossibleDonationDTO;
import com.talyas.reactiveBloodBank.entities.models.Donor;
import com.talyas.reactiveBloodBank.entities.models.Patient;
import com.talyas.reactiveBloodBank.handler.Mappers.PossibleDonorMapper;
import com.talyas.reactiveBloodBank.repositories.DonorRepository;
import com.talyas.reactiveBloodBank.repositories.PatientRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Service
public class PossibleDonationHandler {
    PatientRepository patientRepository;

    DonorRepository donorRepository;
    public PossibleDonationHandler(PatientRepository patientRepository, DonorRepository donorRepository) {
        this.patientRepository = patientRepository;
        this.donorRepository = donorRepository;
    }



    public Mono<ServerResponse> listAllPossibleDonations(ServerRequest request) {
        Flux<Patient> patientFlux = patientRepository.findAll();
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(patientFlux.flatMap(
                        patient -> Mono.just(patient)
                                .map(patientMono -> {
                                    return PossibleDonorMapper.toPossibleDonationDTO(patientMono, donorRepository.findAllByBloodType(patientMono.getBloodType()));
                                })
                                .flatMap(a -> a)
                ), PossibleDonationDTO.class);
    }

    // not needed just to try to return another object
    public Mono<ServerResponse> listAllDonors(ServerRequest request) {

        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(donorRepository.findAll().delayElements(Duration.ofMillis(1000)), Donor.class);
    }

    public Mono<ServerResponse> getPossibleDonationById(ServerRequest request, String id) {
        Mono<Patient> patientMono = patientRepository.findById(Long.valueOf(id));
        return ServerResponse.ok()
                .body(patientMono.map(x -> {
                            Flux<Donor> possibleDonors = donorRepository.findAllByBloodType(x.getBloodType()).take(10);
                            return PossibleDonorMapper.toPossibleDonationDTO(x, possibleDonors);
                        }
                ).flatMap(x -> x)
                        , PossibleDonationDTO.class);
    }

}
