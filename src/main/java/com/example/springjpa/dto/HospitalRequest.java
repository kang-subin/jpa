package com.example.springjpa.dto;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HospitalRequest {
    private Integer id; // hospital이랑 연결된 key (json 에 적는 id 는
    private String reviewTitle;
    private String reviewContent;
    private String reviewUsername;



}
