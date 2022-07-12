package com.talyas.bloodBankMVC.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talyas.bloodBankMVC.services.PossibleDonationService;
import com.talyas.bloodBankMVC.entities.dto.*;


import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
public class PossibleDonationsController {

  private final PossibleDonationService possibleDonationsService;

  @GetMapping(value = "/possibleDonations", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<PossibleDonationDTO> listAllPossibleDonations(){
    return possibleDonationsService.listAllPossibleDonaitons();
  }
  
}
