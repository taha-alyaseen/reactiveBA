package com.talyas.reactiveBloodBank.handler.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.talyas.reactiveBloodBank.entities.dtos.BloodBankDTO;
import com.talyas.reactiveBloodBank.entities.models.BloodBank;

@Mapper(componentModel = "spring")
public interface BloodBankMapper {
  
  @Mapping(source ="id", target="bloodBankId")
  @Mapping(source ="name", target="bloodBankName")
  BloodBankDTO bloodBankToBloodBankDTO(BloodBank bloodBank);


  
}
