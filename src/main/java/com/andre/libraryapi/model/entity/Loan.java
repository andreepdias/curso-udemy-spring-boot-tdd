package com.andre.libraryapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String customer;

    private String customerEmail;

    @JoinColumn(name = "book_id")
    @ManyToOne
    private Book book;
    private LocalDate loanDate;
    private Boolean returned;
}
