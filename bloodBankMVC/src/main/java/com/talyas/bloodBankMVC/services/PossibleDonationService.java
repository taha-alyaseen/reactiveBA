package com.talyas.bloodBankMVC.services;

import com.talyas.bloodBankMVC.entities.dto.PossibleDonationDTO;
import com.talyas.bloodBankMVC.entities.models.Patient;
import com.talyas.bloodBankMVC.repositories.DonorRepository;
import com.talyas.bloodBankMVC.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PossibleDonationService {

    private final DonorRepository donorRepository;
    private final PatientRepository patientRepository;

    public List<PossibleDonationDTO> listAllPossibleDonaitons(){
        Pageable pagesize = PageRequest.of(1, 2);
        List<Patient> allPatients= patientRepository.findAll();
        return allPatients.stream().map(x -> PossibleDonationDTO.builder()
        .id(x.getId())
        .patientName(x.getName())
        .patientsAddress(x.getAddress())
        .patientsBloodTyp(x.getBloodType().toString())
        .patientsMedicalReport(x.getMedicalReport())
        .patientsContactNumber(x.getContactNumber())
        .possibleDonors(donorRepository.findAllByBloodType(x.getBloodType(), pagesize)).build()).collect(Collectors.toList());
    }
    




}
