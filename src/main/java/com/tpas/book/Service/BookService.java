package com.tpas.book.Service;

import com.tpas.book.Entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
    Book saveBook(Book book);
    Book updateBook(Book book, Long bookId);
    void deleteBook(Long id);
}
