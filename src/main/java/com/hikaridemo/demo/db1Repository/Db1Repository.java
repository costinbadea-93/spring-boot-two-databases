package com.hikaridemo.demo.db1Repository;

import com.hikaridemo.demo.db1Entities.BookDb1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Db1Repository extends JpaRepository<BookDb1, Integer> {
}
