package com.example.springjpa.domain;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
    @Id
    private Long id;
    private String name;

}