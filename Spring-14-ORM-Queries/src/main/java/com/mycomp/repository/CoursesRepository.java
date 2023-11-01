package com.mycomp.repository;

import com.mycomp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.stream.Stream;

public interface CoursesRepository extends JpaRepository<Course, Long> {
    /**
     *Derived Query
     */
    //find all courses by category
    List<Course> findByCategory(String category);

    //find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //checks if a course with the provided name exists. return true if the course exists, false otherwise
    Boolean existsByName(String name);

    //returns the count of courses for the provided category
    int countByCategory(String category);


    //find all courses that start with the provided course name
    List<Course> findByNameStartsWith(String name);


    //find all courses by category and returns a stream
    Stream<Course> streamByCategory(String category); //to execute this you need to put @Transactional on DataGenerator class


    /**
     * JPQL
     * named parameters  ':'

     */
    @Query("select c from Course c where c.category= :category and c.rating> :rating")
    List<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);


}
