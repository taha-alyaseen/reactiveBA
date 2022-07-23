package com.talyas.bloodBankMVC.repositories;

import com.talyas.bloodBankMVC.entities.models.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloodBankRepository extends JpaRepository<BloodBank, Long> {

}
