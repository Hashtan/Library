package com.Library.Library.api;

import com.Library.Library.dao.entity.Book;
import com.Library.Library.dao.repo.BookRepo;
import com.Library.Library.manager.BookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookApi {
    private BookManager bookManager;
    private BookRepo bookRepo;

    @Autowired
    public BookApi(BookManager books) {
        this.bookManager = books;
    }


    @GetMapping("/all")
    public Iterable<Book> getAll() {
        return bookManager.findAll();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookManager.save(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return bookManager.save(book);
    }

    @DeleteMapping
    public void deleteBook(@RequestParam Long index) {
        bookManager.deleteById(index);
    }

    @GetMapping
    public Optional<Book> getById(@RequestParam Long index) {
        return bookManager.findById(index);
    }
}
test