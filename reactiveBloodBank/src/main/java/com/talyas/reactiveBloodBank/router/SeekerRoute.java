package com.talyas.reactiveBloodBank.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.RouteMatcher.Route;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.talyas.reactiveBloodBank.handler.SeekersHandler;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SeekerRoute {
  
private final SeekersHandler seekersHandler;

@Bean
public RouterFunction<ServerResponse> routeSeekers(){
  return route(RequestPredicates.GET("/Seekers"), seekersHandler::listAllPatients)
  .andRoute(RequestPredicates.POST("/Seekers"), seekersHandler::createNewSeeker);
}

}
