package com.talyas.bloodBankMVC.handler.Mappers;

import com.talyas.bloodBankMVC.entities.dtos.DonorDTO;
import com.talyas.bloodBankMVC.entities.dtos.PossibleDonationDTO;
import com.talyas.bloodBankMVC.entities.models.Donor;
import com.talyas.bloodBankMVC.entities.models.Seeker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DonorsMapper {
    @Mapping(source="id", target ="donorId")
    @Mapping(source="name", target ="donorName")
    @Mapping(source="bloodType", target ="donorBloodType")
    @Mapping(source="medicalReport", target ="donorMedicalReport")
    @Mapping(source="address", target ="donorAddress")
    @Mapping(source="contactNumber", target ="donorContactNumber")
    @Mapping(source="bloodBankID", target ="bloodBankID")
    DonorDTO toDonorDto(Donor donors);
    List<DonorDTO> toDonorDtoList(List<Donor> donors);
}
