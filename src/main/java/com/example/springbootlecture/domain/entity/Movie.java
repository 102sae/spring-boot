package com.example.springbootlecture.domain.entity;

import com.example.springbootlecture.domain.request.MovieRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "production_year")
    private Integer productionYear;

    @Column(name="created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    //@OneToOne
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director_id")
    private Director director;

    @OneToMany(
            mappedBy = "movie",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Actor> actors;


    public Movie(String name, int productionYear)
    {
        this.name = name;
        this.productionYear = productionYear;

    }

    public void setName(String name)
    {
        this.name = name;
    }
}
