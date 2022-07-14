package com.talyas.reactiveBloodBank.handler;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.talyas.reactiveBloodBank.handler.Mappers.BloodBankMapper;
import com.talyas.reactiveBloodBank.repositories.BloodBankRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BloodBankHandler {
  private final BloodBankRepository bloodBankRepository;
  private final BloodBankMapper bloodBankMapper;

  public Mono<ServerResponse> listAllBloodBanks(ServerRequest request){
    return ServerResponse.ok()
                .body(req -> bloodBankRepository.findAll().map(bloodBankMapper::toBloodBankDTO))
                ), BloodBankDTO.class);
  }
}
