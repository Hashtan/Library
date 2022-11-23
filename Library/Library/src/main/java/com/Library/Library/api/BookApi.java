package com.Library.Library.api;

import com.Library.Library.dao.entity.Book;
import com.Library.Library.manager.BookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookApi {
    private BookManager books;

    @Autowired
    public BookApi(BookManager books) {
        this.books = books;
    }


    @GetMapping("/all")
    public Iterable<Book> getAll() {
        return books.findAll();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return books.save(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return books.save(book);
    }

    @DeleteMapping
    public void deleteBook(@RequestParam Long index) {
        books.deleteById(index);
    }

    @GetMapping
    public Optional<Book> getById(@RequestParam Long index) {
        return books.findById(index);
    }
}
