package com.talyas.reactiveBloodBank.repositories;

import com.talyas.reactiveBloodBank.entities.models.Donor;
import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
 import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface DonorRepository extends ReactiveCrudRepository<Donor, Long> {
    Flux<Donor> findAllByBloodType(EBloodType bloodType);
}
