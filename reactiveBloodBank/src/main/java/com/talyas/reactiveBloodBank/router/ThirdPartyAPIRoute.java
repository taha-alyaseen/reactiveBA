package com.talyas.reactiveBloodBank.router;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@RequiredArgsConstructor
@Configuration
public class ThirdPartyAPIRoute {
    private final WebClient webClient = WebClient.builder().baseUrl("http://localhost:8082/").build();

    @Bean
    public RouterFunction<ServerResponse> getThirdParty() {
        return route(GET("/thirdParty/{delayinMs}") , req -> ServerResponse.ok().body(
                webClient.get()
                        .uri("/thirdParty?delayinMs={delayinMs}", req.pathVariable("delayinMs"))
                        .retrieve()
                .bodyToMono(String.class).map(x -> "webflux-webclient: " + x), String.class));
    }

}
