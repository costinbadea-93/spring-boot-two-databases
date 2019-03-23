package com.hikaridemo.demo.db2Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookDb2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookDb2Id;
    private String bookDb2Name;

    public BookDb2() {}

    public BookDb2(String bookDb2Name) {
        this.bookDb2Name = bookDb2Name;
    }

    public int getBookDb2Id() {
        return bookDb2Id;
    }

    public void setBookDb2Id(int bookDb2Id) {
        this.bookDb2Id = bookDb2Id;
    }

    public String getBookDb2Name() {
        return bookDb2Name;
    }

    public void setBookDb2Name(String bookDb2Name) {
        this.bookDb2Name = bookDb2Name;
    }
}
