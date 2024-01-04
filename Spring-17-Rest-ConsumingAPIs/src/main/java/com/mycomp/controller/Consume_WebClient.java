package com.mycomp.controller;

import com.mycomp.entity.Genre;
import com.mycomp.entity.MovieCinema;
import com.mycomp.repository.GenreRepository;
import com.mycomp.repository.MovieCinemaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {

    private WebClient webClient=WebClient.builder().baseUrl("http://localhost:8080").build();
    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }

    //FLUX for getting many object at the same time in asynchronous
    @GetMapping("/flux-movie-cinemas")
    public Flux<MovieCinema> readAllCinemaFlux() {
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

    //MONO for getting one object at the same time in asynchronous
//    @GetMapping("/mono-movie-cinema/{id}")
//    public Mono<MovieCinema> readById(@PathVariable("id") Long id) {
//        return Mono.just(movieCinemaRepository.findById(id).get());
//    }

    @GetMapping("/mono-movie-cinema/{id}")
    public ResponseEntity<Mono<MovieCinema>> readByI(@PathVariable("id") Long id) {
        return ResponseEntity.ok(Mono.just(movieCinemaRepository.findById(id).get()));
    }

    @PostMapping("creative-genre")
    public Mono<Genre> createGenre(@RequestBody Genre genre){
        Genre newGenre=genreRepository.save(genre);
        return Mono.just(newGenre);
       // return Mono.just(genreRepository.save(genre));
    }

    @DeleteMapping("delete/genre/{id}")
    public Mono<Void>deleteGenre(@PathVariable("id") Long id){
        genreRepository.deleteById(id);
        return Mono.empty();
    }



    //------------------------ WEBCLIENT --------------------------

    @GetMapping("/flux")
    public Flux<MovieCinema> readWithWebClient(){
        return webClient
                .get()
                .uri("/flux-movie-cinemas")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(MovieCinema.class);
    }

    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable("id") Long id){


        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}",id)
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }

}
    /**reactive programming
     -  non-blocking is reactive, because, instead of being
     blocked, we are now in the mode of reacting to notifications as
     operations complete or data becomes available
     -  Spring WebFlux is a counterpart module for Spring MVC. Where
     Spring MVC implements synchronous, blocking I/O, Spring WebFlux
     implements reactive programming via Reactive Streams.
     - WebClient is a reactive, non-blocking client for HTTP requests with a
     functional-style API client and Reactive Streams support. By
     comparison to the RestTemplate, WebClient is:
     • Non-blocking, reactive and supports higher concurrency with less
     hardware resources.
     • Provides a functional API that takes advantage of Java 8 lambdas.
     • Supports both synchronous and asynchronous scenarios
     */

