package com.ftgrl.libraryProject.repository;

import com.ftgrl.libraryProject.entity.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
    List<BorrowingRecord> findByUserId(Long userId);
    List<BorrowingRecord> findByBookId(Long bookId);
}

