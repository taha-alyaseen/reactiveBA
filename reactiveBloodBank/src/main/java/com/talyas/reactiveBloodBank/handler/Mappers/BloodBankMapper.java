package com.talyas.reactiveBloodBank.handler.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.talyas.reactiveBloodBank.entities.dtos.BloodBankDTO;
import com.talyas.reactiveBloodBank.entities.models.BloodBank;

@Mapper(componentModel = "spring")
public interface BloodBankMapper {
  
  @Mapping(source ="id", target="bloodBankDTO.bloodBankId")
  @Mapping(source ="name", target="bloodBankDTO.bloodBankName")
  BloodBankDTO toBloodBankDTO (BloodBank bloodBank);
  
}
