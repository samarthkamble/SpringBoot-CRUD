package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bookstore;
import com.example.demo.services.BookstoreService;

@RestController
@RequestMapping("/bookstore")
public class BookstoreController {
    @Autowired
    BookstoreService bookstoreService;
    
    
    @PostMapping
    public ResponseEntity<Bookstore> saveBook(@RequestBody Bookstore book) {
    
        Bookstore savedBook = bookstoreService.saveBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bookstore> getBookById(@PathVariable Long id) {
    
        Optional<Bookstore> book = bookstoreService.getBookById(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Bookstore>> getAllBooks() {
        List<Bookstore> books = bookstoreService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bookstore> updateBook(@PathVariable Long id, @RequestBody Bookstore bookDetails) {
        Optional<Bookstore> book = bookstoreService.updateBook(id, bookDetails);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id) {
        boolean deleted = bookstoreService.deleteBook(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
