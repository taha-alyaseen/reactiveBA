package com.talyas.reactiveBloodBank.service;

import com.talyas.reactiveBloodBank.entities.db.Donor;
import com.talyas.reactiveBloodBank.entities.dto.DonorDTO;
import com.talyas.reactiveBloodBank.repositories.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DonorService {
    @Autowired
    private DonorRepository donorService;

    public boolean isValid(DonorDTO donorDTO){
        if(donorDTO != null && !donorDTO.getName().isEmpty())
            return true;
        return false;
    }
    public Flux<DonorDTO> getAllDonor(){

    }
    public Mono<DonorDTO> getDonorById(int id){
    }

    @Transactional
    public Mono<DonorDTO> createDonor(DonorDTO donorDTO){

    }

    @Transactional
    public Mono<DonorDTO> updateDonor(DonorDTO donorDTO) {

    }
    @Transactional
    public Mono<Void> deleteDonor(int id){

    }
}
