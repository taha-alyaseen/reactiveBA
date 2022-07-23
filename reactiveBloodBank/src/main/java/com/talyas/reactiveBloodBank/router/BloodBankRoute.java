package com.talyas.reactiveBloodBank.router;

import com.talyas.reactiveBloodBank.handler.BloodBagsHandler;
import com.talyas.reactiveBloodBank.handler.BloodBankHandler;
import com.talyas.reactiveBloodBank.handler.PossibleDonationHandler;
import com.talyas.reactiveBloodBank.handler.SeekersHandler;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RequiredArgsConstructor
@Configuration
public class BloodBankRoute {

    private final BloodBankHandler bloodBankHandler;
    private final BloodBagsHandler bloodBagsHandler;
    private final SeekersHandler seekersHandler;
    private final PossibleDonationHandler possibleDonationHandler;

    @Bean
    public RouterFunction<ServerResponse> getBloodBank() {
        return route(GET("/bloodBanks"), bloodBankHandler::listAllBloodBanks)
                .andRoute(GET("/bloodBanks/{id}"), req -> bloodBankHandler.getDetailedBloodBankById(req, Long.valueOf(req.pathVariable("id"))))
                .andRoute(GET("bloodBanks/{id}/bloodBags"), req -> bloodBagsHandler.listAllBloodBanksBloodBags(req, Long.valueOf(req.pathVariable("id"))))
                .andRoute(GET("bloodBanks/{id}/seekers"), req -> seekersHandler.listAllSeekersInBloodBank(req, Long.valueOf(req.pathVariable("id"))))
                .andRoute(POST("bloodBanks/{id}/seekers"), seekersHandler::createNewSeeker)
                .andRoute(GET("bloodBanks/{bloodBankId}/seekers/{seekerId}/possibleDonation"), req -> possibleDonationHandler.listAllPossibleDonations(req, Long.valueOf(req.pathVariable("bloodBankId")), Long.valueOf(req.pathVariable("seekerId"))))
                .andRoute(GET("bloodBanks/{id}/bloodBags"), req -> bloodBagsHandler.listAllBloodBanksBloodBags(req, Long.valueOf(req.pathVariable("id"))))
                ;
    }



}
