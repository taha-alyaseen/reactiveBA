package com.talyas.reactiveBloodBank.repositories;

import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import com.talyas.reactiveBloodBank.entities.models.BloodBag;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface BloodBagRepository extends ReactiveSortingRepository<BloodBag ,Long> {
    Flux<BloodBag> findAllByBloodBankId(Long bloodBankId);
    Flux<BloodBag> findAllByBloodBankIdAndBloodType(Long bloodBankId, EBloodType bloodType);
    @Query(value="SELECT * FROM blood_bags e WHERE e.blood_type IN (:bloodTypes) AND e.blood_bank_id = :bloodBankID")
    Flux<BloodBag> findAllByBloodBankIdAndBloodTypeIn(Long bloodBankID, List<String> bloodTypes);

}
