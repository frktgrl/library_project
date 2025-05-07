package com.ftgrl.libraryProject.controller;

import com.ftgrl.libraryProject.entity.BorrowingRecord;
import com.ftgrl.libraryProject.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowings")
@RequiredArgsConstructor
public class BorrowingController {

    private final BorrowingService borrowingService;

    @PostMapping("/borrow")
    public ResponseEntity<BorrowingRecord> borrowBook(@RequestParam Long userId, @RequestParam Long bookId) {
        return ResponseEntity.ok(borrowingService.borrowBook(userId, bookId));
    }

    @PostMapping("/return")
    public ResponseEntity<BorrowingRecord> returnBook(@RequestParam Long recordId) {
        return ResponseEntity.ok(borrowingService.returnBook(recordId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BorrowingRecord>> getUserBorrowings(@PathVariable Long userId) {
        return ResponseEntity.ok(borrowingService.getUserBorrowings(userId));
    }
}

