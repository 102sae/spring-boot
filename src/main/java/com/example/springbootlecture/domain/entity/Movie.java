package com.example.springbootlecture.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@RequiredArgsConstructor

//final이 안붙은거 생성자 만들기
@AllArgsConstructor
@Getter
@Setter
public class Movie {
    private long id;

    private String name;
    private Integer productionYear;
    private LocalDateTime createdAt;
}
