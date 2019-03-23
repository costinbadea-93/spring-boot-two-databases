package com.hikaridemo.demo.db2Repository;

import com.hikaridemo.demo.db2Entities.BookDb2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Db2Repository extends JpaRepository<BookDb2, Integer> {
}
