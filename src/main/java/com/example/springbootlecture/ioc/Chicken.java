package com.example.springbootlecture.ioc;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Chicken implements Ingredient{
    private final String name;
}
