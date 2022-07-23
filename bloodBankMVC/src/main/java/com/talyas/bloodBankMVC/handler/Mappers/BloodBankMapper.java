package com.talyas.bloodBankMVC.handler.Mappers;

import com.talyas.bloodBankMVC.entities.dtos.BloodBankDTO;
import com.talyas.bloodBankMVC.entities.models.BloodBank;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BloodBankMapper {
  
  @Mapping(source ="id", target="bloodBankId")
  @Mapping(source ="name", target="bloodBankName")
  BloodBankDTO bloodBankToBloodBankDTO(BloodBank bloodBank);

  @Mapping(source ="id", target="bloodBankId")
  @Mapping(source ="name", target="bloodBankName")
  List<BloodBankDTO> bloodBankToBloodBankDTO(List<BloodBank> bloodBank);


  
}
