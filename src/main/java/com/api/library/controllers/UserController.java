package com.api.library.controllers;

import com.api.library.repositories.UserRepository;
import com.api.library.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository; // Permitir acesso as queries básicas

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Método para salvar usuário
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    // Método para listar todos usuários
    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
    }

    // Método para listar user por ID
    @GetMapping("/{id}") // @PathVariable significa que o programa receberá um valor dinâmico na URL, nesse caso o Long id
    public User findUserById(@PathVariable Long id){
        return (userRepository.findById(id)).orElse(null);
    }

    // Método para deletar os usuários por id
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}