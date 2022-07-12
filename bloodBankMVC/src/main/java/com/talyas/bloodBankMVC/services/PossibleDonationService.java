package com.talyas.bloodBankMVC.services;

import com.talyas.bloodBankMVC.entities.dto.PossibleDonationDTO;
import com.talyas.bloodBankMVC.repositories.DonorRepository;
import com.talyas.bloodBankMVC.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PossibleDonationService {

    private final DonorRepository donorRepository;
    private final PatientRepository patientRepository;





}
