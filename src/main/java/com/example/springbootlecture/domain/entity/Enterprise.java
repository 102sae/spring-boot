package com.example.springbootlecture.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Enterprise {
    private long id;
    private String name;
    private String opinion;
    private String date;
}
