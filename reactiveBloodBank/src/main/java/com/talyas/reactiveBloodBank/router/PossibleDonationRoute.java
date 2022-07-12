package com.talyas.reactiveBloodBank.router;

import com.talyas.reactiveBloodBank.handler.PossibleDonationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class PossibleDonationRoute {

    private PossibleDonationHandler handler;

    public PossibleDonationRoute(PossibleDonationHandler handler) {
        this.handler = handler;
    }

    @Bean
    public RouterFunction<ServerResponse> getPossibleDonation() {
        return route(GET("/possibleDonations"), handler::listAllPossibleDonations).
                andRoute(GET("/possibleDonations/{patienID}"), req -> handler.getPossibleDonationById(req, req.pathVariable("patienID")))
                .andRoute(GET("/donors"), handler::listAllDonors);
    }



}
