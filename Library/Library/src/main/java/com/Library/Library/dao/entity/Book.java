package com.Library.Library.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String title;
    private String author;
    private LocalDate writtenYear;


    public Book() {
    }

    public Book(String title, String author, LocalDate writtenYear) {
        this.title = title;
        this.author = author;
        this.writtenYear = writtenYear;
    }


}
