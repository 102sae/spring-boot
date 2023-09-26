package com.example.springbootlecture.controller;

import com.example.springbootlecture.common.Response;
import com.example.springbootlecture.domain.entity.Log;
import com.example.springbootlecture.domain.entity.Movie;
import com.example.springbootlecture.domain.request.MovieRequest;
import com.example.springbootlecture.domain.response.MovieResponse;
import com.example.springbootlecture.repository.LogRepository;
import com.example.springbootlecture.service.MovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="무비 컨트롤러다")
@RestController
@RequiredArgsConstructor
//api는 공통된 uri
@RequestMapping("/api")
public class MovieController {
    private final MovieService movieService;
    private final LogRepository logRepository;

    @GetMapping("/v1/movies")
    public List<MovieResponse> getMovies(
    ){
        return movieService.getMovies();

    }
    @GetMapping("/v1/movies/{movieId}")
    public MovieResponse getMovie(
            @PathVariable(value = "movieId") long movieId
    ){
        return movieService.getMovie(movieId);

    }

    @PostMapping("/v1/movies")
    public void saveMovie(@RequestBody MovieRequest movieRequest){
        movieService.saveMovie(movieRequest);


        Log log = new Log();
        logRepository.save(log);
    }

    @PutMapping("/v1/movies/{movieId}")
    public void updateMovie(
            @PathVariable(value = "movieId") long movieId,
            @RequestBody MovieRequest movieRequest
    ){
        movieService.updateMovie(movieId,movieRequest);
    }

    @DeleteMapping("/v1/movies/{movieId}")
    public void deleteMovie(
            @PathVariable(value = "movieId") long movieId
    ){
        movieService.deleteMovie(movieId);
    }
}
