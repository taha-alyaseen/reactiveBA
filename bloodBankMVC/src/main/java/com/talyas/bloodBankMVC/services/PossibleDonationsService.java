package com.talyas.bloodBankMVC.services;


import com.talyas.bloodBankMVC.entities.dtos.PossibleDonationDTO;
import com.talyas.bloodBankMVC.entities.models.BloodBag;
import com.talyas.bloodBankMVC.entities.models.BloodBank;
import com.talyas.bloodBankMVC.entities.models.Donor;
import com.talyas.bloodBankMVC.entities.models.Seeker;
import com.talyas.bloodBankMVC.entities.models.enums.EBloodType;
import com.talyas.bloodBankMVC.handler.Mappers.BloodBagMapper;
import com.talyas.bloodBankMVC.handler.Mappers.DonorsMapper;
import com.talyas.bloodBankMVC.repositories.BloodBagRepository;
import com.talyas.bloodBankMVC.repositories.BloodBankRepository;
import com.talyas.bloodBankMVC.repositories.DonorRepository;
import com.talyas.bloodBankMVC.repositories.SeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PossibleDonationsService {
   private final SeekerRepository seekerRepository;
   private final BloodBankRepository bloodBankRepository;
   private final DonorRepository donorRepository;
   private final BloodBagRepository bloodBagRepository;
   private final BloodBagMapper bloodBagMapper;
   private final DonorsMapper donorsMapper;



    public ResponseEntity<PossibleDonationDTO> listAllPossibleDonations(Long bloodBankId, Long seekerId) {
        Optional<Seeker> seeker = seekerRepository.findById(seekerId);
        if (seeker.isPresent()){
            Optional<BloodBank> bloodBank = bloodBankRepository.findById(bloodBankId);
            if(bloodBank.isPresent()){
                List<Donor> possibleDonorList = donorRepository.findAllByBloodBankIDAndBloodTypeIn(bloodBankId, getCompatibleDonationsList(seeker.get().getBloodType()));
                List<BloodBag> availableBloodBagsList = bloodBagRepository.findAllByBloodTypeInAndBloodBankId(getCompatibleDonationsList(seeker.get().getBloodType()), bloodBankId);
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(PossibleDonationDTO.builder()
                        .seekerId(seeker.get().getId())
                        .seekerName(seeker.get().getName())
                        .seekerBloodTyp(seeker.get().getBloodBankID().toString())
                        .seekerMedicalReport(seeker.get().getMedicalReport())
                        .seekerAddress(seeker.get().getAddress())
                        .seekerContactNumber(seeker.get().getContactNumber())
                        .availableBloodBags(bloodBagMapper.toBloodBagDtoList(availableBloodBagsList))
                        .possibleDonors(donorsMapper.toDonorDtoList(possibleDonorList)).build());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    static public List<EBloodType> getCompatibleDonationsList(EBloodType bloodType){
        if (bloodType.equals(EBloodType.ABNegative)) return List.of(EBloodType.ABNegative,EBloodType.ANegative,EBloodType.BNegative,EBloodType.ONegative);
        if (bloodType.equals(EBloodType.ABPositive)) return List.of(EBloodType.ABNegative,EBloodType.ABPositive,EBloodType.ANegative,EBloodType.APositive,EBloodType.BNegative,EBloodType.BPositive,EBloodType.ONegative,EBloodType.OPositive);
        if (bloodType.equals(EBloodType.ANegative) )return List.of(EBloodType.ANegative,EBloodType.ONegative);
        if (bloodType.equals(EBloodType.APositive) )return List.of(EBloodType.ANegative,EBloodType.APositive,EBloodType.ONegative,EBloodType.OPositive);
        if (bloodType.equals(EBloodType.BNegative) )return List.of(EBloodType.BNegative,EBloodType.ONegative);
        if (bloodType.equals(EBloodType.BPositive) )return List.of(EBloodType.BNegative,EBloodType.BPositive,EBloodType.ONegative,EBloodType.OPositive);
        if (bloodType.equals(EBloodType.ONegative) )return List.of(EBloodType.ONegative);
        if (bloodType.equals(EBloodType.OPositive) )return List.of(EBloodType.ONegative,EBloodType.OPositive);
        else return List.of();

    }


}
