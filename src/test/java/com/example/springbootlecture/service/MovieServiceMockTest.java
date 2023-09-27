package com.example.springbootlecture.service;

import com.example.springbootlecture.domain.entity.Actor;
import com.example.springbootlecture.domain.entity.Director;
import com.example.springbootlecture.domain.entity.Movie;
import com.example.springbootlecture.domain.request.MovieRequest;
import com.example.springbootlecture.domain.response.MovieResponse;
import com.example.springbootlecture.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceMockTest {
    @Mock
    private MovieRepository movieRepository;

    @Mock
    private LogService logService;

    @InjectMocks
    private MovieService movieService;

    @Test
    @DisplayName("영화 단건 조회 테스트")
    public void getMovieTest()
    {
        //given
        int movieId = 1;
        Movie movie = new Movie();
        movie.setName("하이");
        //빈 디렉터와 액터
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

        //when
        when(movieRepository.findById(anyLong())).thenReturn(null);

        //then
        assertThrows(NullPointerException.class, () -> movieService.getMovie(movieId));
    }

    @Test
    //@DisplayName("영화 단건 조회 테스트")
    public void 영화단건조회_정상조회_테스트()
    {
        //given
        int movieId = 1;
        Movie movie = new Movie();
        movie.setName("하이");
        //빈 디렉터와 액터
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

        //when
        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));

        //then
        MovieResponse movieResponse = movieService.getMovie(movieId);
        assertNotNull(movieResponse);
    }

    @Test
    //@DisplayName("영화 단건 조회 테스트")
    public void 영화단건조회_불가_테스트()
    {
        //given
        int movieId = 1;
        Movie movie = new Movie();
        movie.setName("하이");
        //빈 디렉터와 액터
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

        //when
        when(movieRepository.findById(anyLong())).thenReturn(null);

        //then
        assertThrows(NullPointerException.class, () -> movieService.getMovie(movieId));
    }

    @Test
    public void 영화단건_저장_테스트 ()
    {

        //given
        MovieRequest request = new MovieRequest("영화명",2022, 1L);
        Movie movie = new Movie("영화명",2022);

        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
        doNothing().when(logService).saveLog();

        //then
        movieService.saveMovie(request);

    }
}
