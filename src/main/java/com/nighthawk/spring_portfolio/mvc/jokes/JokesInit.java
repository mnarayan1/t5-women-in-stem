package com.nighthawk.spring_portfolio.mvc.jokes;

import java.lang.reflect.Array;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component // Scans Application for ModelInit Bean, this detects CommandLineRunner
public class JokesInit {

    // Inject repositories
    @Autowired
    JokesJpaRepository repository;

    @Bean
    CommandLineRunner run() { // The run() method will be executed after the application starts
        return args -> {
            // Fail safe data validations

            // starting jokes
            final Jokes[] jokesArray = {
                    new Jokes(null, "PE Lock", 10, "Bob Joe"),
                    new Jokes(null, "Apple Juice", 5, "Richard"),
                    new Jokes(null, "AP Calculus BC Prep Book ", 15, "Mike"),
                    new Jokes(null, "Used Mac *NOT CLICKBAIT*", 100, "Pranavi"),
                    new Jokes(null, "test entry", 100000, "mads"),
                    new Jokes(null, "idk", 600, "idk")
            };

            // make sure Joke database is populated with starting jokes
            for (Jokes joke : jokesArray) {
                List<Jokes> test = repository.findByNameIgnoreCase(joke.getName());
                if (test.size() == 0) {
                    repository.save(joke); // JPA save
                }
            }
        };
    }
}
