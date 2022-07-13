package com.talyas.bloodBankMVC.repositories;

import com.talyas.bloodBankMVC.entities.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
