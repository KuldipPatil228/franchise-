package com.example.franchise.DTO;

public record FranchiseDto(
        Long id,
        Long ownerId,
        String fuId,
        String franchiseName,
        String street,
        String city,
        String state,
        String postalCode,
        String country,
        boolean isOpen
) {

}
