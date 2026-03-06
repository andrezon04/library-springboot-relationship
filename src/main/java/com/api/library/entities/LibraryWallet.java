package com.api.library.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// Explicações na classe User.java
@Getter
@Setter
@Entity
@Table(name = "wallet")
public class LibraryWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long walletNumber;
    private Date emissionDate;
    private boolean isValid;

    @OneToOne(mappedBy = "user")
    private User user;

}