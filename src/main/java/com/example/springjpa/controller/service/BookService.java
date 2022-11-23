package com.example.springjpa.controller.service;

import com.example.springjpa.domain.Author;
import com.example.springjpa.domain.Book;
import com.example.springjpa.dto.BookResponse;
import com.example.springjpa.repository.AuthorRepository;
import com.example.springjpa.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class BookService {

        private final BookRepository bookRepository;

        private final AuthorRepository authorRepository;

        public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
            this.bookRepository = bookRepository;
            this.authorRepository = authorRepository;
        }

        public List<BookResponse> findBooks(Pageable pageable) {
            Page<Book> books = bookRepository.findAll(pageable);
            List<BookResponse> bookResponses = books.stream()
                    .map(book -> BookResponse.of(book)).collect(Collectors.toList());
            return bookResponses;
        }

    }