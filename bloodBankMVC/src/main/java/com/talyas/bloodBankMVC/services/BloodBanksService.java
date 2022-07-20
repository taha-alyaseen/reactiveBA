package com.talyas.bloodBankMVC.services;

import com.talyas.bloodBankMVC.entities.dtos.BloodBankDTO;
import com.talyas.bloodBankMVC.entities.dtos.BloodBankDetailedDTO;
import com.talyas.bloodBankMVC.entities.models.BloodBag;
import com.talyas.bloodBankMVC.entities.models.BloodBank;
import com.talyas.bloodBankMVC.handler.Mappers.BloodBankMapper;
import com.talyas.bloodBankMVC.repositories.BloodBagRepository;
import com.talyas.bloodBankMVC.repositories.BloodBankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class BloodBanksService {
  private final BloodBankRepository bloodBankRepository;

  private final BloodBagRepository bloodBagRepository;
  private final BloodBankMapper bloodBankMapper;

  public ResponseEntity<List<BloodBankDTO>> listAllBloodBanks() {
    List<BloodBank> allBloodBanks = bloodBankRepository.findAll();
    return ResponseEntity.ok().body(bloodBankMapper.bloodBankToBloodBankDTO(allBloodBanks));
  }
  
  public ResponseEntity<BloodBankDetailedDTO> getDetailedBloodBankById(Long id) {

  Optional<BloodBank> bloodBank = bloodBankRepository.findById(Long.valueOf(id));
  if(bloodBank.isPresent()) {
    List<BloodBag> bloodBags = bloodBagRepository.findAllByBloodBankId(id);
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(BloodBankDetailedDTO.builder().numberOfBloodBags(bloodBags.size())
            .contactNumber(bloodBank.get().getContactNumber())
            .address(bloodBank.get().getAddress())
            .name(bloodBank.get().getName())
            .id(id).build());
  }
  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}