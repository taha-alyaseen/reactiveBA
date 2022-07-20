package com.talyas.reactiveBloodBank.repositories;

import com.talyas.reactiveBloodBank.entities.models.Seeker;

import reactor.core.publisher.Flux;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeekerRepository extends ReactiveCrudRepository<Seeker, Long> {
  Flux<Seeker> findAllByBloodBankID(Long id);
}
