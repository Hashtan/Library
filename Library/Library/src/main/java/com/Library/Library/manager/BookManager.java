package com.Library.Library.manager;

import com.Library.Library.dao.repo.BookRepo;
import com.Library.Library.dao.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookManager {

    private BookRepo bookRepo;

    @Autowired
    public BookManager(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Optional<Book> findById (Long id){
        return bookRepo.findById(id);
    }
    public Iterable<Book> findAll (){
        return bookRepo.findAll();
    }
    public Book save (Book book){
        return bookRepo.save(book);
    }
    public void deleteById (Long id){
        bookRepo.deleteById(id);
    }
    }
