package com.talyas.reactiveBloodBank.repositories;

import com.talyas.reactiveBloodBank.entities.models.Patient;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends R2dbcRepository <Patient, Long> {
}
