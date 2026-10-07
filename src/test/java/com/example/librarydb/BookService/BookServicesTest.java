package com.example.librarydb.BookService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.librarydb.dto.BookDTO;
import com.example.librarydb.model.Book;
import com.example.librarydb.repository.BookRepository;
import com.example.librarydb.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookServicesTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;


    // =====================================================
    // 1. PRUEBA: getAllBooks()
    // =====================================================

    @Test
    void shouldReturnAllBooks() {

        // Arrange
        Book book1 = new Book(
                "1",
                "Clean Code",
                "Robert C. Martin",
                "9780132350884",
                true
        );

        Book book2 = new Book(
                "2",
                "Effective Java",
                "Joshua Bloch",
                "9780134685991",
                false
        );

        List<Book> books = List.of(book1, book2);

        when(bookRepository.findAll()).thenReturn(books);

        // Act
        List<BookDTO> result = bookService.getAllBooks();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());

        assertEquals("1", result.get(0).getId());
        assertEquals("Clean Code", result.get(0).getTitle());
        assertEquals("Robert C. Martin", result.get(0).getAuthor());
        assertEquals("9780132350884", result.get(0).getIsbn());
        assertTrue(result.get(0).isAvailable());

        assertEquals("2", result.get(1).getId());
        assertEquals("Effective Java", result.get(1).getTitle());
        assertFalse(result.get(1).isAvailable());

        verify(bookRepository).findAll();
    }


    // =====================================================
    // 2. PRUEBA: getBookById() - LIBRO EXISTENTE
    // =====================================================

    @Test
    void shouldReturnBookById() {

        // Arrange
        String id = "1";

        Book book = new Book(
                id,
                "Clean Code",
                "Robert C. Martin",
                "9780132350884",
                true
        );

        when(bookRepository.findById(id))
                .thenReturn(Optional.of(book));

        // Act
        BookDTO result = bookService.getBookById(id);

        // Assert
        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("Clean Code", result.getTitle());
        assertEquals("Robert C. Martin", result.getAuthor());
        assertEquals("9780132350884", result.getIsbn());
        assertTrue(result.isAvailable());

        verify(bookRepository).findById(id);
    }

}
