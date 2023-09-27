package com.example.springbootlecture.service;

import com.example.springbootlecture.domain.entity.Movie;
import com.example.springbootlecture.domain.request.MovieRequest;
import com.example.springbootlecture.domain.response.MovieResponse;
import com.example.springbootlecture.repository.LogRepository;
import com.example.springbootlecture.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final LogService logService;
    private LogRepository logRepository;



    //private final EntityManagerFactory emf;
    @Transactional
    public MovieResponse getMovie(long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow();


        return MovieResponse.of(movie);
    /*
        EntityManager entityManager = emf.createEntityManager();
        Movie movie = entityManager.find(Movie.class,movieId);

        return MovieResponse.of(movie);*/
    }

    public List<MovieResponse> getMovies()
    {
        List<Movie> movies = movieRepository.findByProductionYear(2008);
        return movies.stream().map(MovieResponse::of).toList();
    }

    @Transactional
    public void saveMovie(MovieRequest movieRequest) {
        Movie movie = new Movie(movieRequest.getName(),movieRequest.getProductionYear(),movieRequest.getDirectorId());
        movieRepository.save(movie);
        logService.saveLog();

        //throw new RuntimeException("강제 에러");




        /*
        처음 코드
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();

            Movie movie = new Movie(movieRequset.getName(),movieRequset.getProductionYear(), movieRequset.getDirectorId());
           *//*
           rollback 확인 용
           if(movie != null)
            {
                throw new RuntimeException("강제 오류 처리 ");
            }*//*
            entityManager.persist(movie);
            entityManager.flush();
            tx.commit();
        }
        catch (Exception e){
            tx.rollback();
        }*/
    }

    @Transactional
    public void updateMovie(long movieId , MovieRequest movieRequest) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();

        movie.setName("변경");
        movie.setName("변경");
        movie.setName("변경");
        //동일한 변경에 대해서는 바로 변경하지 않고 마지막 update 쿼리만 반영함. -> 쓰기 지연
    }


    @Transactional
    public void deleteMovie(long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        movieRepository.delete(movie);
    }


}
