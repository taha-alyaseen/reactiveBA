package com.talyas.reactiveBloodBank.handler;

import com.talyas.reactiveBloodBank.entities.dtos.ListBloodBagsDTO;
import com.talyas.reactiveBloodBank.entities.models.BloodBag;
import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;
import com.talyas.reactiveBloodBank.handler.Mappers.BloodBagMapper;
import com.talyas.reactiveBloodBank.repositories.BloodBagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Flushable;
import java.util.Collection;

@RequiredArgsConstructor
@Service
public class BloodBagsHandler {
    private final BloodBagMapper bloodBagMapper;
    private final BloodBagRepository bloodBagRepository;

    public Mono<ServerResponse> listAllBloodBanksBloodBags(ServerRequest req, Long id) {
        return ServerResponse.ok()
                .body(Flux.zip(bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.APositive).collectList(),
                                bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.ANegative).collectList(),
                                bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.BPositive).collectList(),
                                bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.BNegative).collectList(),
                                bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.OPositive).collectList(),
                                bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.ONegative).collectList(),
                                bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.ABPositive).collectList(),
                                bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.ABNegative).collectList())
                        .map(x -> {
                            ListBloodBagsDTO listBloodBagsDTO = ListBloodBagsDTO.builder()
                                    .listOfAPositive(bloodBagMapper.toBloodBagDtoList(x.getT1()))
                                    .listOfANegative(bloodBagMapper.toBloodBagDtoList(x.getT2()))
                                    .listOfBPositive(bloodBagMapper.toBloodBagDtoList(x.getT3()))
                                    .listOfBNegative(bloodBagMapper.toBloodBagDtoList(x.getT4()))
                                    .listOfOPositive(bloodBagMapper.toBloodBagDtoList(x.getT5()))
                                    .listOfONegative(bloodBagMapper.toBloodBagDtoList(x.getT6()))
                                    .listOfABPositiv(bloodBagMapper.toBloodBagDtoList(x.getT7()))
                                    .listOfABNegativ(bloodBagMapper.toBloodBagDtoList(x.getT8()))
                                    .build();
                            listBloodBagsDTO.setTotalNumber(listBloodBagsDTO.getListOfAPositive().size()
                                    + listBloodBagsDTO.getListOfANegative().size()
                                    + listBloodBagsDTO.getListOfBPositive().size()
                                    + listBloodBagsDTO.getListOfBNegative().size()
                                    + listBloodBagsDTO.getListOfOPositive().size()
                                    + listBloodBagsDTO.getListOfONegative().size()
                                    + listBloodBagsDTO.getListOfABPositiv().size()
                                    + listBloodBagsDTO.getListOfABNegativ().size());

                            return listBloodBagsDTO; }
                            ),ListBloodBagsDTO.class);
                        }

}