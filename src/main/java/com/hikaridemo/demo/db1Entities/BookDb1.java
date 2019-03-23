package com.hikaridemo.demo.db1Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookDb1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookDb1Id;
    private String bookDb1Name;

    public BookDb1() {}

    public BookDb1(String bookDb1Name) {
        this.bookDb1Name = bookDb1Name;
    }

    public int getBookDb1Id() {
        return bookDb1Id;
    }

    public void setBookDb1Id(int bookDb1Id) {
        this.bookDb1Id = bookDb1Id;
    }

    public String getBookDb1Name() {
        return bookDb1Name;
    }

    public void setBookDb1Name(String bookDb1Name) {
        this.bookDb1Name = bookDb1Name;
    }
}
