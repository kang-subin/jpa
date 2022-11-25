package com.example.springjpa.repository;

import com.example.springjpa.domain.Hospital;
import com.example.springjpa.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository <Review, Integer> {
    List<Review> findByHospital(Optional<Hospital> hospital);
}
