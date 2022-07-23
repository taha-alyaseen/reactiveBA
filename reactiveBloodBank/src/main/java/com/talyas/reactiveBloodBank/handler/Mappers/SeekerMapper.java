package com.talyas.reactiveBloodBank.handler.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.talyas.reactiveBloodBank.entities.dtos.CreateSeekerDTO;
import com.talyas.reactiveBloodBank.entities.dtos.SeekerDTO;
import com.talyas.reactiveBloodBank.entities.models.Seeker;

@Mapper(componentModel = "spring")
public interface SeekerMapper {

  @Mapping(target="id", source ="seekerId")
  @Mapping(target="name", source ="seekerName")
  @Mapping(target="bloodType", source ="seekerBloodType")
  @Mapping(target="medicalReport", source ="seekerMedicalReport")
  @Mapping(target="address", source ="seekerAddress")
  @Mapping(target="contactNumber", source ="seekerContactNumber")
  @Mapping(target="bloodBankID", source ="bloodBankID")
  Seeker toSeeker(SeekerDTO seeker);

  @Mapping(source= "id", target="seekerId")
  @Mapping(source= "name", target="seekerName")
  @Mapping(source= "bloodType", target="seekerBloodType")
  @Mapping(source= "medicalReport", target="seekerMedicalReport")
  @Mapping(source= "address", target="seekerAddress")
  @Mapping(source= "contactNumber", target="seekerContactNumber")
  @Mapping(source= "bloodBankID", target="bloodBankID")
  SeekerDTO toSeekerDTO(Seeker seeker);


  @Mapping(target="id", ignore = true )
  @Mapping(target="name", source ="seekerName")
  @Mapping(target="bloodType", source ="seekerBloodType")
  @Mapping(target="medicalReport", source ="seekerMedicalReport")
  @Mapping(target="address", source ="seekerAddress")
  @Mapping(target="contactNumber", source ="seekerContactNumber")
  @Mapping(target= "bloodBankID", source="bloodBankID")
  Seeker createSeekerDTOtoSeerker(CreateSeekerDTO createSeekerDTO);


}
