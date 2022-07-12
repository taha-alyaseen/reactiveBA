package com.talyas.bloodBankMVC.repositories;

import com.talyas.bloodBankMVC.entities.models.Donor;
import com.talyas.bloodBankMVC.entities.models.enums.EBloodType;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface DonorRepository extends PagingAndSortingRepository<Donor, Long> {
    List<Donor> findAllByBloodType(EBloodType bloodType, Pageable pagesize);
}
