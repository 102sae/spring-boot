package com.example.springbootlecture.domain.response;

import com.example.springbootlecture.domain.entity.Actor;
import com.example.springbootlecture.domain.entity.Movie;
import lombok.*;

import java.util.List;

@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class MovieResponse {
    private final long id;

    private final String name;
    private final Integer productionYear;
    private final String directorName;
    private final List<String> actorName;
    public static MovieResponse of(Movie entity){
        return new MovieResponse(
                entity.getId(),
                entity.getName(),
                entity.getProductionYear(),
                entity.getDirector().getName(),
                entity.getActors().stream().map(Actor::getName).toList()

        );
    }
}
