package com.example.franchise.Entitiy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table
@Data
@Entity
@Setter
@Getter
public class Franchise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner; // Change to @OneToOne for the owner relationship

    private String FuId;

    private String FranchiseName;

    private String street;

    private String city;

    private String state;

    private String postalCode;

    private String country;

    private boolean isOpen;
}
