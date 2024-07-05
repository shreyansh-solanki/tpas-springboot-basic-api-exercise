package com.tpas.book.Service.Impl;

import com.tpas.book.Entity.Book;
import com.tpas.book.Exception.ResourceNotFoundException;
import com.tpas.book.Repository.BookRepo;
import com.tpas.book.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public Book saveBook(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public Book updateBook(Book book, Long bookId) {
        if(bookId == null) {
            throw new ResourceNotFoundException("Book id is required!!");
        }

        Book updateBook = this.bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));

        updateBook.setTitle(book.getTitle());
        updateBook.setAuthor(book.getAuthor());
        updateBook.setIsbn(book.getIsbn());

        return this.bookRepo.save(updateBook);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepo.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        Optional<Book> book = this.bookRepo.findById(id);

        if(book.isEmpty()) {
            throw new ResourceNotFoundException("Book not found with id: " + id);
        }

        return book;
    }

    @Override
    public void deleteBook(Long id) {
        this.bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        this.bookRepo.deleteById(id);
    }


}
