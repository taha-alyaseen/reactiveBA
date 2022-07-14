package com.talyas.reactiveBloodBank.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.talyas.reactiveBloodBank.entities.models.BloodBag;

@Repository
public interface BloodBagRepository extends ReactiveCrudRepository<BloodBag ,Long>{  
}
