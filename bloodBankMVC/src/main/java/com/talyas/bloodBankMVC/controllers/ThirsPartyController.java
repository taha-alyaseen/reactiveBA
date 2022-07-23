package com.talyas.bloodBankMVC.controllers;

import com.talyas.bloodBankMVC.entities.dtos.ListBloodBagsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
public class ThirsPartyController {
    RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/thirdParty/{delayInMs}")
    public ResponseEntity<String> getThirdParty(@PathVariable Long delayInMs){
    return ResponseEntity.ok().body(makeRequestForThirdParty(delayInMs));
    }

    public String makeRequestForThirdParty(Long delay){
        return  "MVC:" + restTemplate.getForObject("http://localhost:8082/thirdParty?delayinMs={delayinMs}",String.class, delay);
    }
}
