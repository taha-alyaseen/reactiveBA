package com.talyas.reactiveBloodBank.handler.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.talyas.reactiveBloodBank.entities.dtos.CreateSeekerDTO;
import com.talyas.reactiveBloodBank.entities.dtos.SeekerDTO;
import com.talyas.reactiveBloodBank.entities.models.Patient;

@Mapper
public interface SeekerMapper {

  @Mapping(source="patient.id", target="seekerDTO.seekerId")
  @Mapping(source="patient.name", target="seekerDTO.seekerName")
  @Mapping(source="patient.bloodType", target="seekerDTO.seekerBloodType")
  @Mapping(source="patient.medicalReport", target="seekerDTO.seekerMedicalReport")
  @Mapping(source="patient.address", target="seekerDTO.seekerAddress")
  @Mapping(source="patient.contactNumber", target="seekerDTO.seekerContactNumber")
  SeekerDTO toSeekerDTO(Patient patient);

  @Mapping(target="patient.id", source ="seekerDTO.seekerId")
  @Mapping(target="patient.name", source ="seekerDTO.seekerName")
  @Mapping(target="patient.bloodType", source ="seekerDTO.seekerBloodType")
  @Mapping(target="patient.medicalReport", source ="seekerDTO.seekerMedicalReport")
  @Mapping(target="patient.address", source ="seekerDTO.seekerAddress")
  @Mapping(target="patient.contactNumber", source ="seekerDTO.seekerContactNumber")
  Patient toPatien(SeekerDTO seeker);


  @Mapping(target="patient.id", ignore = true )
  @Mapping(target="patient.name", source ="seekerDTO.seekerName")
  @Mapping(target="patient.bloodType", source ="seekerDTO.seekerBloodType")
  @Mapping(target="patient.medicalReport", source ="seekerDTO.seekerMedicalReport")
  @Mapping(target="patient.address", source ="seekerDTO.seekerAddress")
  @Mapping(target="patient.contactNumber", source ="seekerDTO.seekerContactNumber")
  Patient toCreateSeekerDTO(CreateSeekerDTO patient);


}
