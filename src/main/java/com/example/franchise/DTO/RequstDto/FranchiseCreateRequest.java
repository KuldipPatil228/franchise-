package com.example.franchise.DTO.RequstDto;

import com.example.franchise.DTO.FranchiseDto;

public record FranchiseCreateRequest(
        Long userId,
        String franchiseName,
        String street,
        String city,
        String state,
        String postalCode,
        String country,
        Boolean isOpen

) {

    public FranchiseDto createFranchise() {
        return new FranchiseDto(null, userId, null, franchiseName, street, city, state, postalCode, country, true);
    }

}
