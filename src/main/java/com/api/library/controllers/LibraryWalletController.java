package com.api.library.controllers;

import com.api.library.entities.LibraryWallet;
import com.api.library.repositories.LibraryWalletRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/librarywallets")
public class LibraryWalletController {
    private LibraryWalletRepository libraryWalletRepository;

    public LibraryWalletController(LibraryWalletRepository libraryWalletRepository) {
        this.libraryWalletRepository = libraryWalletRepository;
    }

    @PostMapping
    public LibraryWallet createWallet(@RequestBody LibraryWallet libraryWallet) {
        return libraryWalletRepository.save(libraryWallet);
    }

}