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
    private int writtenYear;

    private boolean activeStatus = true;

    public Book() {
    }

    public Book(String title, String author, int writtenYear) {
        this.title = title;
        this.author = author;
        this.writtenYear = writtenYear;
    }
}
