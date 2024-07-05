package com.tpas.book.util;


import com.tpas.book.Entity.Book;
import com.tpas.book.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public void run(String... args) throws Exception {
        // Load initial data into the database
        bookRepo.save(new Book("Salem's Lot", "Stephen King", "0451165888"));
        bookRepo.save(new Book("Insomnia: A novel", "Stephen King", "0929480384"));
        bookRepo.save(new Book("Decision in Normandy", "Carlo D'Este", "0060973129"));
        bookRepo.save(new Book("From One to One Hundred", "Teri Sloat", "0525447644"));

    }
}