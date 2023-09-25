package com.example.springbootlecture.service;

import com.example.springbootlecture.domain.entity.Movie;
import com.example.springbootlecture.domain.request.MovieRequest;
import com.example.springbootlecture.domain.response.MovieResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private static List<Movie> movies = new ArrayList<>();
    //생성하기 전에 호출한다. Movie Service가 생성하면서 메소드가 호출.
    @PostConstruct
        public void init() {
        movies.addAll(List.of(
                new Movie(1, "라라랜드", 2017, LocalDateTime.now()),
                new Movie(2, "올드보이", 2005, LocalDateTime.now()),
                new Movie(3, "에브리씽 에브리웨어 올댓원스", 2022,  LocalDateTime.now())
        ));
    }

    public List<MovieResponse> getMovies() {
        return movies.stream().map(MovieResponse::of).toList();
//        return movies.stream().map(movie ->
//                MovieResponse.builder()
//                        .id(movie.getId())
//                        .name(movie.getName())
//                        .productionYear(movie.getProductionYear())
//                        .build()
//          );
    }

    public Movie getMovie(long movieId) {
        return movies.stream()
                .filter(movie -> movie.getId() == movieId)
                .toList()
                .stream()
                .findFirst()
                .orElseThrow();
    }

    public void createMovie(MovieRequest movieRequset) {
        Movie movie = new Movie(
            movies.size()+1,
                movieRequset.getName(),
                movieRequset.getProductionYear(),
                LocalDateTime.now()

        );
        movies.add(movie);
    }
    public void updateMovie(long movieId , MovieRequest movieRequest) {
        Movie movie = getMovie(movieId);
        movie.setName(movieRequest.getName());
        movie.setProductionYear(movieRequest.getProductionYear());

    }


    public void deleteMovie(long movieId) {
        Movie movie = getMovie(movieId);
        movies.remove(movie);
    }



}
