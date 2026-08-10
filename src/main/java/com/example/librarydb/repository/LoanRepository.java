package com.example.librarydb.repository;

import com.example.librarydb.model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends MongoRepository<Loan, String> {

    // BUENA PRÁCTICA: Permite consultar eficientemente todos los prestamos historicos vinculados a un bookId
    List<Loan> findByBookId(String bookId);
}