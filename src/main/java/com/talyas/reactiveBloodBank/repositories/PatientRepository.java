package com.talyas.reactiveBloodBank.repositories;

import com.talyas.reactiveBloodBank.entities.models.Patient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface PatientRepository extends ReactiveCrudRepository <Patient, Integer> {
}
