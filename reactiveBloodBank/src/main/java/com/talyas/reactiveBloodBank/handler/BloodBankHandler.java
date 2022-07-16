package com.talyas.reactiveBloodBank.handler;

import com.talyas.reactiveBloodBank.entities.dtos.BloodBankDTO;
import com.talyas.reactiveBloodBank.entities.dtos.BloodBankDetailedDTO;
import com.talyas.reactiveBloodBank.repositories.BloodBagRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.talyas.reactiveBloodBank.handler.Mappers.BloodBankMapper;
import com.talyas.reactiveBloodBank.repositories.BloodBankRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.management.LockInfo;

@RequiredArgsConstructor
@Service
public class BloodBankHandler {
  private final BloodBankRepository bloodBankRepository;

  private final BloodBagRepository bloodBagRepository;
  private final BloodBankMapper bloodBankMapper;

  public Mono<ServerResponse> listAllBloodBanks(ServerRequest request) {
    return ServerResponse.ok()
            .body(bloodBankRepository.findAll().map(bloodBankMapper::bloodBankToBloodBankDTO)
                    , BloodBankDTO.class);
  }
  public Mono<ServerResponse> getDetailedBloodBankById(ServerRequest request, Long id) {
    return ServerResponse.ok()
            .body(Mono.zip(bloodBankRepository.findById(Long.valueOf(id)),bloodBagRepository.findAllByBloodBankId(id).count())
                    .map(x -> BloodBankDetailedDTO
                            .builder()
                            .id(x.getT1().getId())
                            .name(x.getT1().getName())
                            .address(x.getT1().getAddress())
                            .contactNumber(x.getT1().getContactNumber())
                            .numberOfBloodBags(x.getT2())
                            .build())
                    , BloodBankDetailedDTO.class);
  }
}