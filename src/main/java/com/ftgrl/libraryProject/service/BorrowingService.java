package com.ftgrl.libraryProject.service;

import com.ftgrl.libraryProject.entity.BorrowingRecord;

import java.util.List;

public interface BorrowingService {
    BorrowingRecord borrowBook(Long userId, Long bookId);
    BorrowingRecord returnBook(Long recordId);
    List<BorrowingRecord> getUserBorrowings(Long userId);
}

