package com.example.franchise.Converter;

import com.example.franchise.DTO.CustomerDetailsDTO;
import com.example.franchise.Entitiy.CustomerDetails;

public class CustomerDetailsConverter extends AbstractConverter<CustomerDetailsDTO, CustomerDetails> {

    public CustomerDetailsConverter() {
        super(

                dto -> {
                    CustomerDetails entity = new CustomerDetails();
                    entity.setId(dto.id());
                    entity.setAddress(dto.address());
                    entity.setPaymentMethod(dto.paymentMethod());
                    return entity;
                },

                entity -> new CustomerDetailsDTO(
                        entity.getId(),
                        entity.getUser(),
                        entity.getAddress(),
                        entity.getPaymentMethod()
                )
        );
    }

    public CustomerDetails updateEntity(CustomerDetailsDTO dto, CustomerDetails entity) {
        entity.setId(dto.id());
        entity.setAddress(dto.address());
        entity.setPaymentMethod(dto.paymentMethod());
        return entity;
    }
}
