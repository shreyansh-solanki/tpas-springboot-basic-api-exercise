package com.tpas.book.Controller;

import com.tpas.book.Entity.Book;
import com.tpas.book.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(this.bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable("bookId") Long bookId) {
        return new ResponseEntity<>(this.bookService.getBookById(bookId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return new ResponseEntity<>(this.bookService.saveBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Map<String, String>> deleteBook(@PathVariable("bookId") Long bookId) {
        this.bookService.deleteBook(bookId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Book deleted successfully!! with id: " + bookId);
        response.put("status", String.valueOf(HttpStatus.OK));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") Long bookId) {
        return new ResponseEntity<>(this.bookService.updateBook(book, bookId), HttpStatus.OK);
    }
}
