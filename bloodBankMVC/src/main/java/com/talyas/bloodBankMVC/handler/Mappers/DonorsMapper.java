package com.talyas.bloodBankMVC.handler.Mappers;

import com.talyas.bloodBankMVC.entities.dtos.DonorDTO;
import com.talyas.bloodBankMVC.entities.dtos.PossibleDonationDTO;
import com.talyas.bloodBankMVC.entities.models.Donor;
import com.talyas.bloodBankMVC.entities.models.Seeker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper()
public interface DonorsMapper {
    @Mapping(target="id", source ="seekerId")
    @Mapping(target="name", source ="seekerName")
    @Mapping(target="bloodType", source ="seekerBloodType")
    @Mapping(target="medicalReport", source ="seekerMedica")
    @Mapping(target="address", source ="seekerAddress")
    @Mapping(target="contactNumber", source ="seekerContac")
    @Mapping(target="bloodBankID", source ="bloodBankID")
    List<DonorDTO> toDonorDtoList(List<Donor> donors);
}
