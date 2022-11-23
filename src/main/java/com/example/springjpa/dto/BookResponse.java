package com.example.springjpa.dto;

import com.example.springjpa.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Long bookId;
    private String bookName;
    private String authorName;

    public static BookResponse of(Book book) {
        return BookResponse.builder()
                .bookId(book.getId())
                .bookName(book.getName())
                .authorName(book.getAuthor().getName())
                .build();
    }
}