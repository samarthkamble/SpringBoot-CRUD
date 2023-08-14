package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Bookstore;
import com.example.demo.repo.BookstoreRepository;

@Service
public class BookstoreService {
    @Autowired
    private BookstoreRepository bookstoreRepository;

    public Bookstore saveBook(Bookstore book) {
        return bookstoreRepository.save(book);
    }

    public Optional<Bookstore> getBookById(Long id) {
        return bookstoreRepository.findById(id);
    }

    public List<Bookstore> getAllBooks() {
        return bookstoreRepository.findAll();
    }

    public Optional<Bookstore> updateBook(Long id, Bookstore bookDetails) {
        Optional<Bookstore> optionalBook = bookstoreRepository.findById(id);
        if (optionalBook.isPresent()) {
            Bookstore existingBook = optionalBook.get();
            existingBook.setTitle(bookDetails.getTitle());
            existingBook.setAuthor(bookDetails.getAuthor());
            existingBook.setPrice(bookDetails.getPrice());
            bookstoreRepository.save(existingBook);
        }
        return optionalBook;
    }

    public boolean deleteBook(Long id) {
        try {
            bookstoreRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
