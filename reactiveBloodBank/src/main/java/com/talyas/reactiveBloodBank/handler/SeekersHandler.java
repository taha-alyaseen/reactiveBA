package com.talyas.reactiveBloodBank.handler;

import org.springframework.stereotype.Service;
import org.springframework.web.accept.PathExtensionContentNegotiationStrategy;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.support.ServerRequestWrapper;

import com.talyas.reactiveBloodBank.entities.dtos.SeekerDTO;
import com.talyas.reactiveBloodBank.handler.Mappers.SeekerMapper;
import com.talyas.reactiveBloodBank.repositories.PatientRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
@RequiredArgsConstructor
@Service
public class SeekersHandler {
  private final PatientRepository patientRepository;
  private final SeekerMapper seekerMapper;

  public Mono<ServerResponse> listAllPatients(ServerRequest ServerRequest){
    return ServerResponse.ok()
    .body(patientRepository.findAll().map(seekerMapper::toSeekerDTO), SeekerDTO.class);
  }

  public Mono<ServerResponse> listAllPatientsOfBloodBank(ServerRequest ServerRequest, Long id){
    return ServerResponse.ok()
    .body(patientRepository.findAllByBloodBankID(id).map(seekerMapper::toSeekerDTO), SeekerDTO.class);
  }
  
}
