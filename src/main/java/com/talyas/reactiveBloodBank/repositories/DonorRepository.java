package com.talyas.reactiveBloodBank.repositories;

import com.talyas.reactiveBloodBank.entities.models.Donor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface DonorRepository extends ReactiveCrudRepository <Donor, Integer> {
    Flux<Donor> findAllByBloodType(Enum bloodType);
}
