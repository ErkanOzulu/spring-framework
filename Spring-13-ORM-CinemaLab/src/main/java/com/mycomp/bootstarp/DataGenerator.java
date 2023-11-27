package com.mycomp.bootstarp;

import com.mycomp.repository.AccountRepository;
import com.mycomp.repository.CinemaRepository;
import com.mycomp.repository.GenreRepository;
import com.mycomp.repository.MovieCinemaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Collectors;


@Component
public class DataGenerator implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;
    private final MovieCinemaRepository movieCinemaRepository;

    public DataGenerator(AccountRepository accountRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, MovieCinemaRepository movieCinemaRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.movieCinemaRepository = movieCinemaRepository;
    }
    @Transactional//I added because spring.jpa.hibernate.ddl-auto=none
    @Override
    public void run(String... args) throws Exception {

        accountRepository.findByCountryOrState("United States", "Kentucky");

        accountRepository.findByAgeLessThanEqual(30);

        System.out.println("--------findByName-----------");
        System.out.println(cinemaRepository.findByName("Hall 1 - EMPIRE"));
        System.out.println("--------readTop3BySponsoredNameContaining-----------");
        cinemaRepository.readTop3BySponsoredNameContainingOrderBySponsoredName("Kod").forEach(System.out::println);

        System.out.println("--------findByLocation_Country-----------");
        cinemaRepository.findByLocation_Country("United States").forEach(System.out::println);


        System.out.println("--------findByNameOrSponsoredName-----------");
        cinemaRepository.findAllByNameOrSponsoredName("Hall 1 - EMPIRE","HBO").forEach(System.out::println);

        System.out.println("readCinemaNameById: "+cinemaRepository.readCinemaNameById(10));

        System.out.println("------readAllCinemasByLocationCountry---");
        cinemaRepository.readAllCinemasByLocationCountry("United States").forEach(System.out::println);

        System.out.println("-----readAllByNameOrSponsoredNameContains---");

        cinemaRepository.retrieveAllByNameOrSponsoredName("Kodak").forEach(System.out::println);

        cinemaRepository.sortAllCinemaByName().forEach(System.out::println);

        cinemaRepository.findDistinctBySponsoredName().forEach(System.out::println);

        System.out.println("----Genre----");
        genreRepository.readAllGenre();

        genreRepository.findGenreByNameContains("Drama");

        System.out.println("----MovieCinema----");


        System.out.println(movieCinemaRepository.countAllByCinema_id(2));

        System.out.println(movieCinemaRepository.countMovieCinemaByMovie_id(1L));

        System.out.println(accountRepository.retrieveAllByAgeLessThan(29));
        System.out.println(accountRepository.retrieveBySearchCriteria("Na"));

        movieCinemaRepository.findFirst3ByOrderByMoviePriceDesc().forEach(System.out::println);
        System.out.println(movieCinemaRepository.findAllByMovieNameContains("Tenet"));


    }
}
