package com.andre.libraryapi.service;

import com.andre.libraryapi.api.dto.LoanFilterDTO;
import com.andre.libraryapi.api.resource.BookController;
import com.andre.libraryapi.model.entity.Book;
import com.andre.libraryapi.model.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LoanService {

    Loan save(Loan loan);

    Optional<Loan> getById(Long id);

    Loan update(Loan loan);

    Page<Loan> find(LoanFilterDTO filterDTO, Pageable pageable);

    Page<Loan> getLoansByBook(Book book, Pageable pageable);

    List<Loan> getAllLateLoans();
}
