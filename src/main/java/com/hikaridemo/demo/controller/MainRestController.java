package com.hikaridemo.demo.controller;

import com.hikaridemo.demo.db1Entities.BookDb1;
import com.hikaridemo.demo.db1Repository.Db1Repository;
import com.hikaridemo.demo.db2Entities.BookDb2;
import com.hikaridemo.demo.db2Repository.Db2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MainRestController {

    private final Db1Repository db1Repository;
    private final Db2Repository db2Repository;

    @Autowired
    MainRestController(Db1Repository db1Repository, Db2Repository db2Repository) {
        this.db1Repository = db1Repository;
        this.db2Repository = db2Repository;
    }

    @RequestMapping("/getDataFromBothDatabases")
    public ResponseEntity<?> getDataFromBothDatabases() {
        List<BookDb1> bookDb1 = db1Repository.findAll();
        List<BookDb2> bookDb2 = db2Repository.findAll();

        List<BookDb1> transformBookDb2IntoDb1 = bookDb2.stream()
                .map(bookDb21 -> new BookDb1(bookDb21.getBookDb2Name()))
                .collect(Collectors.toList());

        bookDb1.addAll(transformBookDb2IntoDb1);

        return ResponseEntity.ok(bookDb1);
    }
}
