package com.talyas.reactiveBloodBank.router;

import com.talyas.reactiveBloodBank.handler.BloodBagsHandler;
import com.talyas.reactiveBloodBank.handler.BloodBankHandler;
import com.talyas.reactiveBloodBank.handler.SeekersHandler;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RequiredArgsConstructor
@Configuration
public class BloodBankRoute {

    private final BloodBankHandler bloodBankHandler;
    private final BloodBagsHandler bloodBagsHandler;
    private final SeekersHandler seekersHandler;


    @Bean
    public RouterFunction<ServerResponse> getBloodBank() {
        return route(GET("/bloodBanks"), bloodBankHandler::listAllBloodBanks)
                .andRoute(GET("/bloodBanks/{id}"), req -> bloodBankHandler.getDetailedBloodBankById(req, Long.valueOf(req.pathVariable("id"))))
                .andRoute(GET("bloodBanks/{id}/bloodBags"), req -> bloodBagsHandler.listAllBloodBanksBloodBags(req, Long.valueOf(req.pathVariable("id"))))
                .andRoute(GET("bloodBanks/{id}/patients"), req -> 
       /*not finished */             bloodBagsHandler.listAllBloodBanksBloodBags(req, Long.valueOf(req.pathVariable("id"))))
                .andRoute(GET("bloodBanks/{id}/bloodBags/possibleDonations"), req -> 
       /*not finished */             bloodBagsHandler.listAllBloodBanksBloodBags(req, Long.valueOf(req.pathVariable("id"))));
    }



}
