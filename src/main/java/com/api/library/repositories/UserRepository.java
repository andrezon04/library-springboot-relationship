package com.api.library.repositories;

import com.api.library.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
                                // extende a interface e passa a clase(user) e o tipo
                                // de dado(id = long)
public interface UserRepository extends JpaRepository<User, Long> {
    // Permite acesso as queries básicas(save, findAll, findById e deleteById)
}