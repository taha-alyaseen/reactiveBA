package com.talyas.reactiveBloodBank;

import com.talyas.reactiveBloodBank.entities.models.Donor;
import com.talyas.reactiveBloodBank.entities.models.Seeker;
import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;
import com.talyas.reactiveBloodBank.repositories.DonorRepository;
import com.talyas.reactiveBloodBank.repositories.SeekerRepository;
import com.talyas.reactiveBloodBank.router.PossibleDonationRoute;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

public class listAllPossibleDonationsTest extends ReactiveBloodBankApplicationTests {
    @Autowired
    private PossibleDonationRoute possibleDonationRoute;



/*    //@Test
    public void shouldReturnAllPossibleDonations() {
        Seeker[] seekers = {
                new Seeker(1l,
                        "name",
                        EBloodType.ABNegative,
                        "medicalReport",
                        "address",
                        "contactNumber"),
                new Seeker(2l,
                        "name",
                        EBloodType.ABPositive,
                        "medicalReport",
                        "address",
                        "contactNumber"),
                new Seeker(3l,
                        "name",
                        EBloodType.APositive,
                        "medicalReport",
                        "address",
                        "contactNumber")
        };
        Flux<Seeker> patientFlux = Flux.just(seekers);
        Donor[] donorsABNegative = {
                new Donor(1l,
                        "name",
                        EBloodType.ABNegative,
                        "medicalReport",
                        "address",
                        "contactNumber"),
                new Donor(4l,
                        "name",
                        EBloodType.ABNegative,
                        "medicalReport",
                        "address",
                        "contactNumber")
        };
        Donor[] donorsABPositive = {new Donor(2l,
                "name",
                EBloodType.ABPositive,
                "medicalReport",
                "address",
                "contactNumber"),
                new Donor(5l,
                        "name",
                        EBloodType.ABPositive,
                        "medicalReport",
                        "address",
                        "contactNumber")
        };
        Donor[] donorsAPositive = {new Donor(3l,
                "name",
                EBloodType.APositive,
                "medicalReport",
                "address",
                "contactNumber"),
                new Donor(6l,
                        "name",
                        EBloodType.APositive,
                        "medicalReport",
                        "address",
                        "contactNumber")
        };
        Flux<Donor> donorsABNegativeFlux = Flux.just(donorsABNegative);
        Flux<Donor> donorsABPositiveFlux = Flux.just(donorsABPositive);
        Flux<Donor> donorsAPositiveFlux = Flux.just(donorsAPositive);
        SeekerRepository seekerRepository = Mockito.mock(SeekerRepository.class);
        DonorRepository donorRepository = Mockito.mock(DonorRepository.class);
        Mockito.when(seekerRepository.findAll()).thenReturn(patientFlux);
        Mockito.when(donorRepository.findAllByBloodType(EBloodType.ABNegative)).thenReturn(donorsABNegativeFlux);
        Mockito.when(donorRepository.findAllByBloodType(EBloodType.ABPositive)).thenReturn(donorsABPositiveFlux);
        Mockito.when(donorRepository.findAllByBloodType(EBloodType.APositive)).thenReturn(donorsAPositiveFlux);

        WebTestClient testClient = WebTestClient.bindToRouterFunction(possibleDonationRoute.getPossibleDonation()).build();

        testClient.get().uri("/possibleDonations")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody();
    }*/
}
