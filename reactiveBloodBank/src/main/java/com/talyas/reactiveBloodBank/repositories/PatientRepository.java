package com.talyas.reactiveBloodBank.repositories;

import com.talyas.reactiveBloodBank.entities.models.Patient;

import reactor.core.publisher.Flux;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends ReactiveCrudRepository<Patient, Long> {
  Flux<Patient> findAllByBloodBankID(Long id);
}
