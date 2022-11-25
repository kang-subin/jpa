package com.example.springjpa.dto;


import com.example.springjpa.domain.Hospital;
import com.example.springjpa.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder

@NoArgsConstructor
@Getter
public class HospitalResponse {

    private Integer id;

    private String hospitalName;
    private String reviewTitle;
    private String reviewContent;
    private String reviewUsername;

    private String message;

    public HospitalResponse (Integer id, String hospitalName, String reviewTitle , String reviewContent, String reviewUsername, String message){

        this.id = id;
        this.hospitalName = hospitalName;
        this.reviewTitle =reviewTitle;
        this.reviewContent =reviewContent;
        this.reviewUsername = reviewUsername;
        this.message = message;
    }


    public HospitalResponse(Integer id, String reviewTitle, String reviewContent, String reviewUsername, String massage) {
        this.id =id;
        this.reviewTitle =reviewTitle;
        this.reviewContent =reviewContent;
        this.reviewUsername = reviewUsername;
        this.message = message;

    }
}
