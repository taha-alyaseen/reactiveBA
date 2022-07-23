package com.talyas.reactiveBloodBank.handler;

import com.talyas.reactiveBloodBank.entities.dtos.CreateSeekerDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.talyas.reactiveBloodBank.entities.dtos.SeekerDTO;
import com.talyas.reactiveBloodBank.handler.Mappers.SeekerMapper;
import com.talyas.reactiveBloodBank.repositories.SeekerRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_NDJSON_VALUE;

@RequiredArgsConstructor
@Service
public class SeekersHandler {
  private final SeekerRepository seekerRepository;
  private final SeekerMapper seekerMapper;

  public Mono<ServerResponse> listAllPatients(ServerRequest ServerRequest){
    return ServerResponse.accepted().contentType(MediaType.TEXT_EVENT_STREAM)
    .body(seekerRepository.findAll().map(seekerMapper::toSeekerDTO), SeekerDTO.class);
  }

  public Mono<ServerResponse> listAllSeekersInBloodBank(ServerRequest ServerRequest, Long id){
    return ServerResponse.ok()
    .body(seekerRepository.findAllByBloodBankID(id).map(seekerMapper::toSeekerDTO), SeekerDTO.class);
  }

  public Mono<ServerResponse> createNewSeeker(ServerRequest request) {
  return request.bodyToMono(CreateSeekerDTO.class)
          .flatMap(seeker -> seekerRepository.save(seekerMapper.createSeekerDTOtoSeerker(seeker)))
          .flatMap(seeker -> ServerResponse.created(URI.create("/seekers/"+ seeker.getId())).contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(seeker)));
  }
}
