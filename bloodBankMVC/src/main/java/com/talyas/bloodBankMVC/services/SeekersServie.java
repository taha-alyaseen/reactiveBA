package com.talyas.bloodBankMVC.services;

import com.talyas.bloodBankMVC.entities.dtos.CreateSeekerDTO;
import com.talyas.bloodBankMVC.entities.dtos.SeekerDTO;
import com.talyas.bloodBankMVC.entities.models.BloodBank;
import com.talyas.bloodBankMVC.entities.models.Seeker;
import com.talyas.bloodBankMVC.entities.models.enums.EBloodType;
import com.talyas.bloodBankMVC.handler.Mappers.SeekerMapper;
import com.talyas.bloodBankMVC.repositories.BloodBankRepository;
import com.talyas.bloodBankMVC.repositories.SeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SeekersServie {
  private final SeekerRepository seekerRepository;
  private final SeekerMapper seekerMapper;

  private final BloodBankRepository bloodBankRepository;

  public ResponseEntity<List<SeekerDTO>> listAllSeekers(){
    List<SeekerDTO>  seekerDTOList = seekerMapper.toSeekerDTOList(seekerRepository.findAll());
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
    .body(seekerDTOList);
  }

  public ResponseEntity<List<SeekerDTO>> listAllSeekersInBloodBank(Long id){
    Optional<BloodBank> bloodBank = bloodBankRepository.findById(id);
    if(bloodBank.isPresent()) {
      List<SeekerDTO> seekerDTOList = seekerMapper.toSeekerDTOList(seekerRepository.findAllByBloodBankID(id));
      return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
              .body(seekerDTOList);
    }
  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  public ResponseEntity<SeekerDTO> createNewSeekerInBloodBank(CreateSeekerDTO createSeekerDTO, Long bloodBankID) {
    Optional<BloodBank> bloodBank = bloodBankRepository.findById(bloodBankID);
    if(bloodBank.isPresent()) {
      final Seeker seeker = Seeker.builder().id(null).address(createSeekerDTO.getSeekerAddress())
              .contactNumber(createSeekerDTO.getSeekerContactNumber())
              .name(createSeekerDTO.getSeekerName())
              .bloodType(EBloodType.valueOf(createSeekerDTO.getSeekerBloodType()))
              .bloodBankID(bloodBankID)
              .medicalReport(createSeekerDTO.getSeekerMedicalReport()).build();
      Seeker savedSeeker = seekerRepository.save(seeker);
      return ResponseEntity.created(URI.create("/seekers/"+ seeker.getId())).contentType(MediaType.APPLICATION_JSON)
              .body(seekerMapper.toSeekerDTO(savedSeeker));
    }
    return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
