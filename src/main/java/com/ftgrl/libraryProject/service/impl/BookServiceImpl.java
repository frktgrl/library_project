package com.ftgrl.libraryProject.service.impl;

import com.ftgrl.libraryProject.dto.BookDto;
import com.ftgrl.libraryProject.entity.Book;
import com.ftgrl.libraryProject.repository.BookRepository;
import com.ftgrl.libraryProject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book saveBook(BookDto bookDto) {
        Book book = Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .isbn(bookDto.getIsbn())
                .genre(bookDto.getGenre())
                .publishDate(bookDto.getPublishDate())
                .available(true)
                .build();
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAvailableBooks() {
        return bookRepository.findByAvailableTrue();
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }
}


