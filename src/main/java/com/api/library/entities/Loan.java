package com.api.library.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// Explicações na classe User.java
@Getter
@Setter
@Entity
@Table(name = "tb_loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date loanDate;
    private Date returnDate;

    @ManyToOne
    private User user;

}