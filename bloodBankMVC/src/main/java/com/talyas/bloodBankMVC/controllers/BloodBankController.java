package com.talyas.bloodBankMVC.controllers;

import com.talyas.bloodBankMVC.entities.dtos.*;
import com.talyas.bloodBankMVC.services.BloodBagsService;
import com.talyas.bloodBankMVC.services.BloodBanksService;
import com.talyas.bloodBankMVC.services.PossibleDonationsService;
import com.talyas.bloodBankMVC.services.SeekersServie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BloodBankController {
    private final BloodBagsService bloodBagsService;
    private final SeekersServie seekersServie;
    private final BloodBanksService bloodBanksService;
    private final PossibleDonationsService possibleDonationsService;


    @GetMapping("/bloodBanks")
    public ResponseEntity<List<BloodBankDTO>> getAllBloodBanks() {
        return bloodBanksService.listAllBloodBanks();
    }

    @GetMapping("/bloodBanks/{id}")
    public ResponseEntity<BloodBankDetailedDTO> getDetailedBloodBankById(@PathVariable Long id) {
        return bloodBanksService.getDetailedBloodBankById(id);
    }

    @GetMapping("/bloodBanks/{id}/bloodBags")
    public ResponseEntity<ListBloodBagsDTO> getListOfBloodBagsInBloodBank(@PathVariable Long id) {
        return bloodBagsService.listAllBloodBagsInBloodBank(id);
    }

    @GetMapping("/bloodBanks/{id}/seekers")
    public ResponseEntity<List<SeekerDTO>> getListOfSeekersInBloodBank(@PathVariable Long id) {
        return seekersServie.listAllSeekersInBloodBank(id);
    }

    @GetMapping("/bloodBanks/{bloodBankId}/seekers/{seekerId}/possibleDonation")
    public ResponseEntity<PossibleDonationDTO> getAllPossibleDonationsForSeekerInBloodBank(@PathVariable Long bloodBankId, @PathVariable Long seekerId){
        return possibleDonationsService.listAllPossibleDonations(bloodBankId,seekerId);
    }
    @PostMapping("/bloodBanks/{id}/seekers")
    public ResponseEntity<SeekerDTO> createNewSeekerInBloodBank(@RequestBody CreateSeekerDTO createSeekerDTO, @PathVariable Long id) {
    return seekersServie.createNewSeekerInBloodBank(createSeekerDTO,id);
    }

}