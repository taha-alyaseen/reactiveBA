package com.talyas.reactiveBloodBank.repositories;

import com.talyas.reactiveBloodBank.entities.models.Donor;
import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface DonorRepository extends ReactiveSortingRepository<Donor, Long> {
    Flux<Donor> findAllByBloodType(EBloodType bloodType);
    @Query(value="SELECT * FROM donors e WHERE e.blood_type IN (:bloodTypes) AND e.blood_bank_id = :bloodBankID")
    Flux<Donor> findAllByBloodBankIDAndBloodTypeIn(Long bloodBankID, List<String> bloodTypes);
}
