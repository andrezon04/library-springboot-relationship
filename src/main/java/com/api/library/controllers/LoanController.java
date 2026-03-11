package com.api.library.controllers;

import com.api.library.entities.Loan;
import com.api.library.repositories.LoanRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private LoanRepository loanRepository;

    public LoanController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan){
        return loanRepository.save(loan);
    }

    @GetMapping
    public List<Loan> findAll(){
        return loanRepository.findAll();
    }

    @GetMapping("/{id}")
    public Loan findLoanById(@PathVariable Long id){
        return (loanRepository.findById(id)).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteLoanById(@PathVariable Long id){
        loanRepository.deleteById(id);
    }

}