package com.talyas.reactiveBloodBank.repositories;

import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.talyas.reactiveBloodBank.entities.models.BloodBag;
import reactor.core.publisher.Flux;

@Repository
public interface BloodBagRepository extends ReactiveCrudRepository<BloodBag ,Long>{  
    Flux<BloodBag> findAllByBloodBankId(Long bloodBankId);
    Flux<BloodBag> findAllByBloodBankIdAndBloodType(Long bloodBankId, EBloodType bloodType);
}
