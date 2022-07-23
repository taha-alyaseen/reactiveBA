package com.talyas.bloodBankMVC.controllers;

import com.talyas.bloodBankMVC.entities.dtos.SeekerDTO;
import com.talyas.bloodBankMVC.entities.models.Seeker;
import com.talyas.bloodBankMVC.services.SeekersServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeekersController {
    @Autowired
    SeekersServie seekersServie;
    @GetMapping("/seekers")
    public ResponseEntity<List<SeekerDTO>> getAllSeekers(){
        return seekersServie.listAllSeekers();
    }
}
