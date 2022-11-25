package com.example.springjpa.controller;

import com.example.springjpa.domain.Review;
import com.example.springjpa.dto.ReviewReadResponse;
import com.example.springjpa.service.HospitialService;
import com.example.springjpa.dto.HospitalRequest;
import com.example.springjpa.dto.HospitalResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RequiredArgsConstructor // 필요한 argument를 넣어줌
@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitialService hospitialService; // 생성자 안만들어도 됨

    @GetMapping("/{id}")
    public ResponseEntity<ReviewReadResponse> getReview (@PathVariable Integer id){
    Review review = hospitialService.getReview(id);
    ReviewReadResponse response = ReviewReadResponse.builder()
            .id(review.getId())
            .title(review.getTitle())
            .content(review.getContent())
            .patientName(review.getUserName())
            .build();
    return ResponseEntity.ok().body(response);
    }

@PostMapping("/{id}/reviews")
    public ResponseEntity<HospitalResponse> addReview( @RequestBody HospitalRequest hospitalRequest)
    {    return ResponseEntity.ok().body(hospitialService.add(hospitalRequest));
    }

}
