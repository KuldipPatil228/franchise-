package com.example.franchise.Entitiy;

import jakarta.persistence.*;
import lombok.Data;

    @Entity
    @Data
    @Table(name = "user_address")
    public class UserAddress {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String street;

        private String city;

        private String state;

        private String postalCode;

        private String country;

        @OneToOne(mappedBy = "address")
        private User user;
}
