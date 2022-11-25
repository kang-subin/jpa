package com.example.springjpa.domain;


import com.example.springjpa.dto.HospitalResponse;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
@Getter
public class Hospital {
    @Id
    private Integer id;
    private String roadNameAddress;
    private String Name;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private List<Review> reviews;


}