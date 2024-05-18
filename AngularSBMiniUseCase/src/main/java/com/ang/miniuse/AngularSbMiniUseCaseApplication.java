package com.ang.miniuse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class AngularSbMiniUseCaseApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(AngularSbMiniUseCaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String countrySql = FileUtils.readFileToString(
                new File("src/main/resources/CountriesStatesCities/country.sql"),
                StandardCharsets.UTF_8);
        String stateSql = FileUtils.readFileToString(
                new File("src/main/resources/CountriesStatesCities/state.sql"),
                StandardCharsets.UTF_8);
        String citySql = FileUtils.readFileToString(
                new File("src/main/resources/CountriesStatesCities/city.sql"),
                StandardCharsets.UTF_8);

        try {
            jdbcTemplate.execute(countrySql);
        } catch (Exception ex) {
            System.out.println("Country is already inserted, ignoring it!");
        }

        try {
            jdbcTemplate.execute(stateSql);
        } catch (Exception ex) {
            System.out.println("State is already inserted, ignoring it!");
        }

        try {
            jdbcTemplate.execute(citySql);
        } catch (Exception ex) {
            System.out.println("City is already inserted, ignoring it!");
        }

    }
}
