package com.api.library.repositories;

import com.api.library.entities.LibraryWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryWalletRepository extends JpaRepository<LibraryWallet,Long> {

}