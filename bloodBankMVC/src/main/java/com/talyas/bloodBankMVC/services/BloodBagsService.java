package com.talyas.bloodBankMVC.services;

import com.talyas.bloodBankMVC.entities.dtos.ListBloodBagsDTO;
import com.talyas.bloodBankMVC.entities.models.BloodBag;
import com.talyas.bloodBankMVC.entities.models.enums.EBloodType;
import com.talyas.bloodBankMVC.handler.Mappers.BloodBagMapper;
import com.talyas.bloodBankMVC.repositories.BloodBagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Service
public class BloodBagsService {
    private final BloodBagMapper bloodBagMapper;
    private final BloodBagRepository bloodBagRepository;

    public ResponseEntity<ListBloodBagsDTO> listAllBloodBagsInBloodBank(Long id) {
        List<BloodBag> listOfAPositive= bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.APositive);
        List<BloodBag> listOfANegative= bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.ANegative);
        List<BloodBag> listOfBPositive= bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.BPositive);
        List<BloodBag> listOfBNegative= bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.BNegative);
        List<BloodBag> listOfOPositive= bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.OPositive);
        List<BloodBag> listOfONegative= bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.ONegative);
        List<BloodBag> listOfABPositiv= bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.ABPositive);
        List<BloodBag> listOfABNegativ= bloodBagRepository.findAllByBloodBankIdAndBloodType(id, EBloodType.ABNegative);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ListBloodBagsDTO.builder()
                                    .listOfAPositive(bloodBagMapper.toBloodBagDtoList(listOfAPositive))
                                    .listOfANegative(bloodBagMapper.toBloodBagDtoList(listOfANegative))
                                    .listOfBPositive(bloodBagMapper.toBloodBagDtoList(listOfBPositive))
                                    .listOfBNegative(bloodBagMapper.toBloodBagDtoList(listOfBNegative))
                                    .listOfOPositive(bloodBagMapper.toBloodBagDtoList(listOfOPositive))
                                    .listOfONegative(bloodBagMapper.toBloodBagDtoList(listOfONegative))
                                    .listOfABPositiv(bloodBagMapper.toBloodBagDtoList(listOfABPositiv))
                                    .listOfABNegativ(bloodBagMapper.toBloodBagDtoList(listOfABNegativ))
                                    .totalNumber(listOfABNegativ.size()
                                            + listOfAPositive.size()
                                            + listOfANegative.size()
                                            + listOfBPositive.size()
                                            + listOfBNegative.size()
                                            + listOfOPositive.size()
                                            + listOfONegative.size()
                                            + listOfABPositiv.size())
                                    .build());
        }

}