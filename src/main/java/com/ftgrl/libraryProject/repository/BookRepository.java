package com.ftgrl.libraryProject.repository;

import com.ftgrl.libraryProject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAvailableTrue();
}

