package com.andre.libraryapi.model.repository;

import com.andre.libraryapi.model.entity.Book;
import com.andre.libraryapi.model.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("select case when ( count(l.id) > 0 ) then true else false end " +
            "from Loan l where l.book = :book and (l.returned is null or l.returned is false)")
    boolean existsByBookAndNotReturned(@Param("book") Book book);

    @Query("select l from Loan as l join l.book as b where b.isbn = :isbn or l.customer = :customer")
    Page<Loan> findByBookIsbnOrCustomer(
            @Param("isbn") String isbn,
            @Param("customer") String customer,
            Pageable pageRequest
    );

    Page<Loan> findByBook(Book book, Pageable pageable);

    @Query("SELECT l FROM Loan l WHERE l.loanDate <= :threeDaysAgo AND (l.returned IS NULL OR l.returned IS FALSE)")
    List<Loan> findByLoanDateLessThanAndNotReturned(@Param("threeDaysAgo") LocalDate threeDaysAgo);
}
