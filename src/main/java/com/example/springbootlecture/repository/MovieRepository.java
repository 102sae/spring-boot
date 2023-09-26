package com.example.springbootlecture.repository;

import com.example.springbootlecture.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{

    @Query("SELECT distinct m FROM Movie m LEFT JOIN FETCH m.actors a LEFT JOIN FETCH m.director d")
    List<Movie> findAlljpqlFetch();

    List<Movie> findByProductionYear(int productionYear);


}
