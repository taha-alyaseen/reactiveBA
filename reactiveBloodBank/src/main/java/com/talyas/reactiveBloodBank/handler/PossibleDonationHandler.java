package com.talyas.reactiveBloodBank.handler;

import com.talyas.reactiveBloodBank.entities.dtos.PossibleDonationDTO;
import com.talyas.reactiveBloodBank.entities.models.BloodBag;
import com.talyas.reactiveBloodBank.entities.models.Donor;
import com.talyas.reactiveBloodBank.entities.models.Seeker;
import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;
import com.talyas.reactiveBloodBank.handler.Mappers.BloodBagMapper;
import com.talyas.reactiveBloodBank.handler.Mappers.DonorsMapper;
import com.talyas.reactiveBloodBank.handler.Mappers.PossibleDonorMapper;
import com.talyas.reactiveBloodBank.repositories.BloodBagRepository;
import com.talyas.reactiveBloodBank.repositories.BloodBankRepository;
import com.talyas.reactiveBloodBank.repositories.DonorRepository;
import com.talyas.reactiveBloodBank.repositories.SeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxExtensionsKt;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PossibleDonationHandler {
    private final SeekerRepository seekerRepository;

    private final DonorRepository donorRepository;
    private final BloodBankRepository bloodBankRepository;
    private final BloodBagRepository bloodBagRepository;
    private final DonorsMapper donorsMapper;

    private final BloodBagMapper bloodBagMapper;




    public Mono<ServerResponse> listAllPossibleDonations(ServerRequest request, Long bloodBankId, Long seekerId) {
        return ServerResponse.ok()
                .body(seekerRepository.findById(seekerId).flatMap(seeker -> Mono.zip(bloodBagRepository.findAllByBloodBankIdAndBloodTypeIn(bloodBankId, getCompatibleDonationsList(seeker.getBloodType())).collectList()
                        ,donorRepository.findAllByBloodBankIDAndBloodTypeIn(bloodBankId, getCompatibleDonationsList(seeker.getBloodType())).collectList())
                                        .flatMap(x -> Mono.just(PossibleDonationDTO.builder().seekerId(seeker.getId())
                                                .seekerContactNumber(seeker.getContactNumber())
                                                .seekerAddress(seeker.getAddress())
                                                .seekerName(seeker.getName())
                                                .seekerBloodTyp(seeker.getBloodType().toString())
                                                .seekerMedicalReport(seeker.getMedicalReport())
                                                .possibleDonors(donorsMapper.toDonorDtoList(x.getT2()))
                                                .availableBloodBags(bloodBagMapper.toBloodBagDtoList(x.getT1())).build())))
                        , PossibleDonationDTO.class);
    }


    static public List<String> getCompatibleDonationsList(EBloodType bloodType){
        if (bloodType.equals(EBloodType.ABNegative)) return List.of("ABNegative","ANegative","BNegative","ONegative");
        if (bloodType.equals(EBloodType.ABPositive)) return List.of("ABNegative","ABPositive","ANegative","APositive","BNegative","BPositive","ONegative","OPositive");
        if (bloodType.equals(EBloodType.ANegative)) return List.of("ANegative","ONegative");
        if (bloodType.equals(EBloodType.APositive)) return List.of("ANegative","APositive","ONegative","OPositive");
        if (bloodType.equals(EBloodType.BNegative)) return List.of("BNegative","ONegative");
        if (bloodType.equals(EBloodType.BPositive)) return List.of("BNegative","BPositive","ONegative","OPositive");
        if (bloodType.equals(EBloodType.ONegative)) return List.of("ONegative");
        if (bloodType.equals(EBloodType.OPositive)) return List.of("ONegative","OPositive");
        else return List.of();

    }


}
