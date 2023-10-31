package com.mycomp.bootstarp;

import com.mycomp.entity.Region;
import com.mycomp.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {


 private final RegionRepository regionRepository;

    public DataGenerator(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("------------------REGION START------------------");


        List<Region> canada = regionRepository.findByCountry("Canada");
        System.out.println("findByCountry: "+canada);

        System.out.println("findDistinctByCountry: "+regionRepository.findDistinctByCountry("Canada"));

        System.out.println("findByCountryContaining: "+regionRepository.findByCountryContaining("United"));

        System.out.println("findByCountryIsContainingOrderByCountry: "+regionRepository.findByCountryIsContainingOrderByCountry("Asia"));

        System.out.println("findTop2ByCountry: "+regionRepository.findTop2ByCountry("Canada"));

        System.out.println("------------------REGION END------------------");


    }
}
