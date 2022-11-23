package com.example.springjpa.controller;

import com.example.springjpa.controller.service.BookService;
import com.example.springjpa.dto.BookResponse;
import com.example.springjpa.repository.BookRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<List<BookResponse>> getAll(Pageable pageable) {
        return ResponseEntity.ok().body(bookService.findBooks(pageable));
    }

}
