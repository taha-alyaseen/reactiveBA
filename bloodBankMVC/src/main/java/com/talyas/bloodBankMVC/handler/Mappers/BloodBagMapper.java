package com.talyas.bloodBankMVC.handler.Mappers;

import com.talyas.bloodBankMVC.entities.dtos.BloodBagDTO;
import com.talyas.bloodBankMVC.entities.models.BloodBag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BloodBagMapper {
    BloodBagDTO toBloodBagDto(BloodBag bloodBag);
    List<BloodBagDTO> toBloodBagDtoList(List<BloodBag> bloodBag);



}
