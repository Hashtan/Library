package com.Library.Library.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long borrowId;
    private LocalDate borrowStart;
    private LocalDate borrowEnd;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    public Borrowing(Book book, User user) {
        this.borrowStart = LocalDate.now();
        this.book = book;
        this.user = user;
    }
}
