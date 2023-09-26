package com.example.springbootlecture.domain.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MovieRequest {
    private final String name;
    private final Integer productionYear;


}
