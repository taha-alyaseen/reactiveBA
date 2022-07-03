package com.talyas.reactiveBloodBank.router;

import com.talyas.reactiveBloodBank.entities.dto.PossibleDonationDTO;
import com.talyas.reactiveBloodBank.entities.models.Donor;
import com.talyas.reactiveBloodBank.entities.models.Patient;
import com.talyas.reactiveBloodBank.mapper.PossibleDonorMapper;
import com.talyas.reactiveBloodBank.repositories.DonorRepository;
import com.talyas.reactiveBloodBank.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class PossibleDonationRoute {

    @Autowired
    DonorRepository donorRepository;
    @Autowired
    PatientRepository patientRepository;

    @Bean
    RouterFunction<?> getPossibleDonation() {
        return route(GET("/possibleDonations"), this::listAllPossibleDonations).
                andRoute(GET("/possibleDonation/{patienID}"), req -> listPossibleDonations(req, req.pathVariable("patienID")));
    }

    public Mono<ServerResponse> listAllPossibleDonations(ServerRequest request) {
        Flux<Patient> patientFlux = patientRepository.findAll();
        return ServerResponse.ok()
                .body(patientFlux.flatMap(
                patient -> Mono.just(patient)
                        .map(patientMono -> {
                            Flux<Donor> possibleDonors = donorRepository.findAllByBloodType(patientMono.getBloodType());
                            return PossibleDonorMapper.toPossibleDonationDTO(patientMono, possibleDonors);
                        })
                        .subscribeOn(Schedulers.parallel())
        ), PossibleDonationDTO.class);
    }

    public Mono<ServerResponse> listPossibleDonations(ServerRequest request, String id) {
        Mono<Patient> patientMono = patientRepository.findById(Integer.valueOf(id));
        return ServerResponse.ok()
                .body(patientMono.map(x -> {
                    Flux<Donor> possibleDonors = donorRepository.findAllByBloodType(x.getBloodType());
                    return PossibleDonorMapper.toPossibleDonationDTO(x, possibleDonors);
                }
        ), PossibleDonationDTO.class);
    }

}
