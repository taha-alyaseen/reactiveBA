package com.talyas.reactiveBloodBank.repositories;

import com.talyas.reactiveBloodBank.entities.db.Donor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;


public interface DonorRepository extends ReactiveCrudRepository <Donor, Integer> {
    public Mono<Donor> save(Donor donor);

}
