package com.ftgrl.libraryProject.service;

import com.ftgrl.libraryProject.dto.BookDto;
import com.ftgrl.libraryProject.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book saveBook(BookDto bookDto);
    List<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
    void deleteBook(Long id);
    List<Book> getAvailableBooks();
    Book updateBook(Book book);
}
