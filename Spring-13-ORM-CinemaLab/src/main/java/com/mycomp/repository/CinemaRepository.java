package com.mycomp.repository;

import com.mycomp.entity.Cinema;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name

    List<Cinema>readTop3BySponsoredNameContainingOrderBySponsoredName(String sponsoredName);

    //Write a derived query to list all cinemas in a specific country

    List<Cinema>findByLocation_Country(String country);


    //Write a derived query to list all cinemas with a specific name or sponsored name

    List<Cinema>findAllByNameOrSponsoredName(String name, String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id

    // @Query("select c.name from Cinema c where c.id=?1") --same as below

    @Query("select c.name from Cinema c where c.id=:id")
    String readCinemaNameById(@Param("id") long id);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country

    @Query(value = "select * from cinema c left join location l on c.location_id=l.id where l.country=:country",nativeQuery = true)
    List<Cinema>readAllCinemasByLocationCountry(@Param("country")String country);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "select * from cinema where name ILIKE concat('%',?1,'%') or sponsored_name ILIKE concat('%',?1,'%')",nativeQuery = true)
     List<Cinema>retrieveAllByNameOrSponsoredName(String pattern);


    //Write a native query to sort all cinemas by name
    @Query(value ="select * from cinema order by name",nativeQuery = true)
    List<Cinema>sortAllCinemaByName();

    //Write a native query to distinct all cinemas by sponsored name
    @Query(value ="select distinct sponsored_name from cinema",nativeQuery = true)
    List<String> findDistinctBySponsoredName();



}
