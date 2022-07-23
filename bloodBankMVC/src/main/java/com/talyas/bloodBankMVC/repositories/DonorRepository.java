package com.talyas.bloodBankMVC.repositories;

import com.talyas.bloodBankMVC.entities.models.Donor;
import com.talyas.bloodBankMVC.entities.models.enums.EBloodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
    List<Donor> findAllByBloodBankIDAndBloodTypeIn(Long bloodBankID, List<EBloodType> bloodType);
}
