package com.example.librarydb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

// Mapea la clase a la coleccion "loans" en MongoDB
@Document(collection = "loans")
public class Loan {

    @Id
    private String id;

    // BUENA PRÁCTICA: Guardar el ID plano de Book en vez de usar @DBRef.
    // @Indexed crea un indice secundario en MongoDB para agilizar la busqueda findByBookId()
    @Indexed
    private String bookId;

    private String userName;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan() {}

    public Loan(String id, String bookId, String userName, LocalDate loanDate, LocalDate returnDate) {
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