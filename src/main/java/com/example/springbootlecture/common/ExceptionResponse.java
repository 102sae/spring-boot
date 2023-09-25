package com.example.springbootlecture.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//매핑용 리스판스 객체
@RequiredArgsConstructor
@Getter
public class ExceptionResponse {
    private final String message;
    private final int code;
}
