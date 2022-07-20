package com.talyas.bloodBankMVC.services;


import com.talyas.bloodBankMVC.entities.dtos.PossibleDonationDTO;
import com.talyas.bloodBankMVC.entities.models.BloodBank;
import com.talyas.bloodBankMVC.entities.models.Donor;
import com.talyas.bloodBankMVC.entities.models.Seeker;
import com.talyas.bloodBankMVC.repositories.BloodBankRepository;
import com.talyas.bloodBankMVC.repositories.DonorRepository;
import com.talyas.bloodBankMVC.repositories.SeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PossibleDonationsService {
    SeekerRepository seekerRepository;
    BloodBankRepository bloodBankRepository;
    DonorRepository donorRepository;




    public ResponseEntity<PossibleDonationDTO> listAllPossibleDonations(Long bloodBankId, Long seekerId) {
        Optional<Seeker> seeker = seekerRepository.findById(seekerId);
        if (patientFlux.isPresent()){
            Optional<BloodBank> bloodBank = bloodBankRepository.findById(bloodBankId);
            if(bloodBank.isPresent()){
                List<Donor> donorList
            }
        }

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                .body();
    }
    static public List<String> getCompatibleDonationsList(String bloodType){
        if (bloodType.equals("ABNegativ")) return List.of("ABNegative","ANegative","BNegative","ONegative");
        if (bloodType.equals("ABPositiv")) return List.of("ABNegative","ABPositive","ANegative","APositive","BNegative","BPositive","ONegative","OPositive");
        if (bloodType.equals("ANegative")) return List.of("ANegative","Negative");
        if (bloodType.equals("APositive")) return List.of("ANegative","APositive","ONegative","OPositive");
        if (bloodType.equals("BNegative")) return List.of("BNegative","ONegative");
        if (bloodType.equals("BPositive")) return List.of("BNegative","BPositive","ONegative","OPositive");
        if (bloodType.equals("ONegative")) return List.of("ONegative");
        if (bloodType.equals("OPositive")) return List.of("ONegative","OPositive");
        else return List.of();

    }

}
