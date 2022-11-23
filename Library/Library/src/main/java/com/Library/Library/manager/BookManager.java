package com.Library.Library.manager;

import com.Library.Library.dao.entity.Borrowing;
import com.Library.Library.dao.entity.User;
import com.Library.Library.dao.repo.BookRepo;
import com.Library.Library.dao.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        Book book1 = new Book ("tytułtestowy1", "autordlajaj", LocalDate.of(2022, 12, 30));
        Book book2 = new Book ("Boston", "Mariusz Max Kolonko", LocalDate.of(2013, 10, 7));
        User user = new User("Oskar");
        Borrowing borrowing1 = new Borrowing(book1, user);
        save(book1); save(book2);


    }


}
