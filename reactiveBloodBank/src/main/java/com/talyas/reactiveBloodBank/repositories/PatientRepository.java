package com.talyas.reactiveBloodBank.repositories;

import com.talyas.reactiveBloodBank.entities.models.Patient;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


public interface PatientRepository extends ReactiveCrudRepository<Patient, Long> {
}
