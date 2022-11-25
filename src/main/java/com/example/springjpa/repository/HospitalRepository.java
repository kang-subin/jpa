package com.example.springjpa.repository;

import com.example.springjpa.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
