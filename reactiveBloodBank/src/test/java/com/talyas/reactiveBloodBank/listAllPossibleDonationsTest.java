package com.talyas.reactiveBloodBank;

import com.talyas.reactiveBloodBank.entities.models.Donor;
import com.talyas.reactiveBloodBank.entities.models.Patient;
import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;
import com.talyas.reactiveBloodBank.repositories.DonorRepository;
import com.talyas.reactiveBloodBank.repositories.PatientRepository;
import com.talyas.reactiveBloodBank.router.PossibleDonationRoute;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

public class listAllPossibleDonationsTest extends ReactiveBloodBankApplicationTests {
    @Autowired
    private PossibleDonationRoute possibleDonationRoute;



    @Test
    public void shouldReturnAllPossibleDonations() {
        Patient[] patients = {
                new Patient(1l,
                        "name",
                        EBloodType.ABNegative,
                        "medicalReport",
                        "address",
                        "contactNumber"),
                new Patient(2l,
                        "name",
                        EBloodType.ABPositive,
                        "medicalReport",
                        "address",
                        "contactNumber"),
                new Patient(3l,
                        "name",
                        EBloodType.APositive,
                        "medicalReport",
                        "address",
                        "contactNumber")
        };
        Flux<Patient> patientFlux = Flux.just(patients);
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
        PatientRepository patientRepository = Mockito.mock(PatientRepository.class);
        DonorRepository donorRepository = Mockito.mock(DonorRepository.class);
        Mockito.when(patientRepository.findAll()).thenReturn(patientFlux);
        Mockito.when(donorRepository.findAllByBloodType(EBloodType.ABNegative)).thenReturn(donorsABNegativeFlux);
        Mockito.when(donorRepository.findAllByBloodType(EBloodType.ABPositive)).thenReturn(donorsABPositiveFlux);
        Mockito.when(donorRepository.findAllByBloodType(EBloodType.APositive)).thenReturn(donorsAPositiveFlux);

        WebTestClient testClient = WebTestClient.bindToRouterFunction(possibleDonationRoute.getPossibleDonation()).build();

        testClient.get().uri("/possibleDonations")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody();
    }
}
