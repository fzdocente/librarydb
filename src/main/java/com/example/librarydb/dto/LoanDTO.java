package com.example.librarydb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class LoanDTO {

    private String id;

    // Obliga a proporcionar el ID plano del libro
    @NotBlank(message = "El ID del libro es obligatorio")
    private String bookId;

    @NotBlank(message = "El nombre del usuario que solicita el prestamo es obligatorio")
    private String userName;

    // Asegura que la fecha contenga un valor no nulo
    @NotNull(message = "La fecha de prestamo es obligatoria")
    private LocalDate loanDate;

    private LocalDate returnDate;

    public LoanDTO() {}

    public LoanDTO(String id, String bookId, String userName, LocalDate loanDate, LocalDate returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.userName = userName;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public LocalDate getLoanDate() { return loanDate; }
    public void setLoanDate(LocalDate loanDate) { this.loanDate = loanDate; }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}