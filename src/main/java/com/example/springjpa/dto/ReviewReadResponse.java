package com.example.springjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReviewReadResponse {
    private Integer id;
    private String title;
    private String content;
    private String patientName;
    private String hospitalName;
}