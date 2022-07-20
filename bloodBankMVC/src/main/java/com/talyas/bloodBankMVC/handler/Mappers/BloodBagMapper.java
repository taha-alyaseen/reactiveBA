package com.talyas.reactiveBloodBank.handler.Mappers;

import com.talyas.reactiveBloodBank.entities.dtos.BloodBagDTO;
import com.talyas.reactiveBloodBank.entities.models.BloodBag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BloodBagMapper {
    BloodBagDTO toBloodBagDto(BloodBag bloodBag);
    List<BloodBagDTO> toBloodBagDtoList(List<BloodBag> bloodBag);



}
