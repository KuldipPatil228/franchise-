package com.example.franchise.Entitiy;

import com.example.franchise.Enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String mobileNumber;

    private String password;

    private String userName;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private UserAddress address;

    @ManyToOne(fetch = FetchType.LAZY) // or FetchType.EAGER based on your requirement
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    public User() {

    }
}
