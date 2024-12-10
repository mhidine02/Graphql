package com.example.banque_service.repositories;

import com.example.banque_service.entities.Compte;
import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;

import java.util.List;

public interface CompteRepository extends JpaRepository<Compte, Long> {
    @Query("SELECT COALESCE(SUM(c.solde), 0) FROM Compte c")
    double sumSoldes();
}
