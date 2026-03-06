package com.api.library.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter // O Lombok gera os getters e setters "nos fundos" automaticamente para poupar tempo e deixar o código mais limpo
@Setter

@Entity // Define que é uma tabela para o database
@Table(name = "users") // Especificar o nome da tabela no Database
public class User {
    @Id // Define que é uma chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o ID será gerado automaticamente de modo auto incremental
    private Long id;
    private String name;
    private String email;

    @OneToOne // Define que o relacionamento é exclusivo um-para-um
    private LibraryWallet libraryWallet;

    @OneToMany(mappedBy = "user") //Define que o relacionamento é um-para-muitos e diz para o databse que
    private List<Loan> loans;
}