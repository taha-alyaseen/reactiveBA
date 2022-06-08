package com.talyas.reactiveBloodBank.controller;

import com.talyas.reactiveBloodBank.entities.dto.DonorDTO;
import com.talyas.reactiveBloodBank.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class DonorController {

    @Autowired
    private DonorService donorService;

    @GetMapping("/donors")
    public ResponseEntity<Flux<DonorDTO>> getAllDonors(){
        return ResponseEntity.ok(donorService.getAllDonor());
    }

    @GetMapping("/donors/{id}")
    public ResponseEntity<Mono<DonorDTO>> getDonorById(@PathVariable int id){
        return ResponseEntity.ok(donorService.getDonorById(id));
    }

    @PostMapping("/donors")
    public ResponseEntity<Mono<DonorDTO>> createDonor(@RequestBody DonorDTO donorDTO){
        if(!donorService.isValid(donorDTO)) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        donorService.createDonor(donorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/donors")
    public ResponseEntity<Mono<DonorDTO>> updateDonor(@RequestBody DonorDTO donorDTO){
        if(donorService.isValid(donorDTO)) return ResponseEntity.ok(donorService.updateDonor(donorDTO));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
