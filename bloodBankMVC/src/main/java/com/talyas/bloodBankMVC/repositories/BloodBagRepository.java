package com.talyas.bloodBankMVC.repositories;

import com.talyas.bloodBankMVC.entities.models.BloodBag;
import com.talyas.bloodBankMVC.entities.models.enums.EBloodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodBagRepository extends JpaRepository<BloodBag,Long>{
    List<BloodBag> findAllByBloodBankId(Long bloodBankId);
    List<BloodBag> findAllByBloodTypeInAndBloodBankId(List<EBloodType> bloodTypes,Long bloodBankId);

    List<BloodBag> findAllByBloodBankIdAndBloodType(Long bloodBankId,EBloodType bloodType);
}
