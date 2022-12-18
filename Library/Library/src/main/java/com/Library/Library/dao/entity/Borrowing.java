package com.Library.Library.dao.entity;

import com.Library.Library.dao.AppUser.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate borrowStart;
    private LocalDate expectedReturnDate;
    private LocalDate borrowEnd;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    public Borrowing(Book book, User user) {
        this.book = book;
        this.user = user;
    }
}

