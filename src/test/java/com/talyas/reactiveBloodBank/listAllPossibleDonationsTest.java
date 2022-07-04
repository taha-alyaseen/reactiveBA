package com.talyas.reactiveBloodBank;

import com.talyas.reactiveBloodBank.entities.models.Donor;
import com.talyas.reactiveBloodBank.entities.models.Patient;
import com.talyas.reactiveBloodBank.entities.models.enums.EBloodType;
import com.talyas.reactiveBloodBank.repositories.DonorRepository;
import com.talyas.reactiveBloodBank.repositories.PatientRepository;
import com.talyas.reactiveBloodBank.router.PossibleDonationRoute;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;
public class listAllPossibleDonationsTest {
    @Autowired
    private PossibleDonationRoute possibleDonationRoute;
/*    @MockBean
    private DonorRepository donorRepository;
    @MockBean
    private PatientRepository patientRepository;*/
    @Test
    public void shouldReturnAllPossibleDonations() {
        Patient[] patients = {
                new Patient(1,
                        "name",
                        EBloodType.ABNegative,
                        "medicalReport",
                        "address",
                        "contactNumber"),
                new Patient(2,
                        "name",
                        EBloodType.ABPositive,
                        "medicalReport",
                        "address",
                        "contactNumber"),
                new Patient(3,
                        "name",
                        EBloodType.APositive,
                        "medicalReport",
                        "address",
                        "contactNumber")
        };
        Flux<Patient> patientFlux = Flux.just(patients);
        Donor[] donorsABNegative = {
                new Donor(1,
                        "name",
                        EBloodType.ABNegative,
                        "medicalReport",
                        "address",
                        "contactNumber"),
                new Donor(4,
                        "name",
                        EBloodType.ABNegative,
                        "medicalReport",
                        "address",
                        "contactNumber")
        };
        Donor[] donorsABPositive = {new Donor(2,
                "name",
                EBloodType.ABPositive,
                "medicalReport",
                "address",
                "contactNumber"),
                new Donor(5,
                        "name",
                        EBloodType.ABPositive,
                        "medicalReport",
                        "address",
                        "contactNumber")
        };
        Donor[] donorsAPositive = {new Donor(3,
                "name",
                EBloodType.APositive,
                "medicalReport",
                "address",
                "contactNumber"),
                new Donor(6,
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

        WebTestClient testClient = WebTestClient.bindToRouterFunction(this.possibleDonationRoute.getPossibleDonation()).build();

        testClient.get().uri("/possibleDonations").exchange().expectStatus().isOk();
    }
}
