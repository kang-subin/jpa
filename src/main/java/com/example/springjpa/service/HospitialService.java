package com.example.springjpa.service;

import com.example.springjpa.domain.Hospital;
import com.example.springjpa.domain.Review;
import com.example.springjpa.dto.HospitalRequest;
import com.example.springjpa.dto.HospitalResponse;
import com.example.springjpa.dto.ReviewReadResponse;
import com.example.springjpa.repository.HospitalRepository;
import com.example.springjpa.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitialService {

    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public HospitialService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    public HospitalResponse add(HospitalRequest hospitalRequest) {
        Optional<Hospital> hospital = hospitalRepository.findById(hospitalRequest.getId()); // json으로 저장할 병원 ID를 입력한 후
        Review review = Review.builder() // json 에 받은 값을 넣어주고
                .title(hospitalRequest.getReviewTitle())
                .content(hospitalRequest.getReviewContent())
                .userName(hospitalRequest.getReviewUsername())
                .hospital(hospital.get())
                .build();
        Review savedReview = reviewRepository.save(review); // review entity에 저장하고
        return new HospitalResponse(savedReview.getId(), savedReview.getTitle(), savedReview.getContent(), savedReview.getUserName(), "리뷰 등록 완료");
        // 저장한 값을 response에 넣는다
    }

    public HospitalResponse findId(Integer id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id); // 병원 Id가 5 인 병원의 리뷰를 출력
        Optional<Review> review = reviewRepository.findById(hospital.get().getId()); // 병원 id 5 = 리뷰 id 5번
        return new HospitalResponse(
                hospital.get().getId(),
                hospital.get().getName(), // 이거 왜 안불러와 짐(칼럼이랑 필드명이랑 달라서 안불러와졌던것임)
                review.get().getTitle(),
                review.get().getContent(),
                review.get().getUserName(),
                "리뷰 불러오기 성공");
        // 병원 id 가 5인 병원의 리뷰를 출력
    }

    public Review getReview(Integer id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 id가 없습니다.")); // optinal 대신 사용 가능
        return review;
    }


    public List<ReviewReadResponse> getReview2(Integer id) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 id가 없습니다."));
        List<ReviewReadResponse> reviews = reviewRepository.findByHospital(Optional.ofNullable(hospital))
                    .stream().map(review -> ReviewReadResponse.builder()
                            .id(review.getId())
                            .title(review.getTitle())
                            .content(review.getContent())
                            .patientName(review.getUserName())
                            .hospitalName(review.getHospital().getName())
                            .build()
                    ).collect(Collectors.toList());

        return reviews;
        }

    }







