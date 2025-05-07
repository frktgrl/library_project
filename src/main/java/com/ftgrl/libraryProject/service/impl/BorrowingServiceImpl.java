package com.ftgrl.libraryProject.service.impl;

import com.ftgrl.libraryProject.entity.Book;
import com.ftgrl.libraryProject.entity.BorrowingRecord;
import com.ftgrl.libraryProject.entity.User;
import com.ftgrl.libraryProject.repository.BookRepository;
import com.ftgrl.libraryProject.repository.BorrowingRecordRepository;
import com.ftgrl.libraryProject.repository.UserRepository;
import com.ftgrl.libraryProject.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowingServiceImpl implements BorrowingService {
    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public BorrowingRecord borrowBook(Long userId, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        if (!book.isAvailable()) throw new RuntimeException("Book is not available");

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        book.setAvailable(false);
        bookRepository.save(book);

        BorrowingRecord record = BorrowingRecord.builder()
                .book(book)
                .user(user)
                .borrowDate(LocalDate.now())
                .dueDate(LocalDate.now().plusDays(14))
                .build();

        return borrowingRecordRepository.save(record);
    }

    @Override
    public BorrowingRecord returnBook(Long recordId) {
        BorrowingRecord record = borrowingRecordRepository.findById(recordId).orElseThrow(() -> new RuntimeException("Record not found"));
        record.setReturnDate(LocalDate.now());

        Book book = record.getBook();
        book.setAvailable(true);
        bookRepository.save(book);

        return borrowingRecordRepository.save(record);
    }

    @Override
    public List<BorrowingRecord> getUserBorrowings(Long userId) {
        return borrowingRecordRepository.findByUserId(userId);
    }
}



