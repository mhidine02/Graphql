package com.example.banque_service.controllers;

import java.util.List;
import java.util.Map;

import com.example.banque_service.entities.Compte;
import com.example.banque_service.repositories.CompteRepository;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class CompteControllerGraphQL {
    private CompteRepository compteRepository;

    @QueryMapping
    public List<Compte> allComptes() {
        return compteRepository.findAll();
    }

    @QueryMapping
    public Compte compteById(@Argument Enum type) {
        Compte compte = compteRepository.fin.orElse(null) ;
        if (compte == null) {
            throw new RuntimeException(String.format("Compte %s not found", id));
        }else {return compte ;}
    }

    @MutationMapping
    public Compte saveCompte(@Argument Compte compte) {
        return compteRepository.save(compte);
    }

    @QueryMapping
    public Map<String, Object> totalSolde() {
        long count = compteRepository.count();
        double sum = compteRepository.sumSoldes();
        double average = count > 0 ? sum /count : 0;
        return Map.of("count", count, "sum", sum, "average", average);
    }

}