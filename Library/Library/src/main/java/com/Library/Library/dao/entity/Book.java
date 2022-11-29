package com.Library.Library.dao.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private LocalDate writtenYear;

    private boolean activeStatus;

    public Book() {
    }

    public Book(String title, String author, LocalDate writtenYear, boolean activeStatus) {
        this.title = title;
        this.author = author;
        this.writtenYear = writtenYear;
        this.activeStatus = true;
    }

    public Book(String author, LocalDate writtenYear) {
        this.author = author;
        this.writtenYear = writtenYear;
    }
}
