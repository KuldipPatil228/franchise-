package com.example.franchise.Converter;

import com.example.franchise.DTO.FranchiseDto;
import com.example.franchise.Entitiy.Franchise;


public class FranchiseConverter extends AbstractConverter<FranchiseDto,Franchise>{

    public FranchiseConverter() {
        super(
                dto -> {
                    Franchise entity = new Franchise();
                    entity.setFuId(dto.fuId());
                    entity.setFranchiseName(dto.franchiseName());
                    entity.setStreet(dto.street());
                    entity.setCity(dto.city());
                    entity.setState(dto.state());
                    entity.setPostalCode(dto.postalCode());
                    entity.setCountry(dto.country());
                    return entity;
                },

                entity -> new FranchiseDto(
                        entity.getId(),
                        entity.getOwner() != null ? entity.getOwner().getId() : null,
                        entity.getFuId(),
                        entity.getFranchiseName(),
                        entity.getStreet(),
                        entity.getCity(),
                        entity.getState(),
                        entity.getPostalCode(),
                        entity.getCountry(),
                        entity.isOpen()
                )
        );
    }
}
