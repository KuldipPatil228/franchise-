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
                    // You might need to handle the user separately depending on how it's managed in your DTO
                    // entity.setUser(userService.findById(dto.getUserId())); // Example: Assuming you have a userService to fetch the user
                    return entity;
                },

                entity -> new CustomerDetailsDTO(
                        entity.getId(),
                        entity.getUser(),
                        entity.getAddress(),
                        entity.getPaymentMethod()
                        // You might need to handle the user separately depending on how it's managed in your entity
                        // entity.getUser().getId() // Example: Assuming you have a userId in your DTO
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
