package com.example.springjpa.domain;

import com.example.springjpa.dto.BookResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
@Id
    private Long id;
    private String name;
    private Long authorId;


    public BookResponse toDto (Book book){
        return new BookResponse(book.getId(), book.getName(), book.getAuthorId());
    }

}
