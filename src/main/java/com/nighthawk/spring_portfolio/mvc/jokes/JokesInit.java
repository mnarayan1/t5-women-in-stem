package com.nighthawk.spring_portfolio.mvc.jokes;

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
            final String[] jokesArray = {
                    "PE Lock, bob@urmom.com",
                    "AP Calculus BC Prep Book, bob@urmom.com",
                    "Pranavi's Apple Bundle *Not Clickbait*, bob@urmom.com",
                    "Meena's TINspire, bob@urmom.com",
            };

            // make sure Joke database is populated with starting jokes
            for (String joke : jokesArray) {
                List<Jokes> test = repository.findByJokeIgnoreCase(joke); // JPA lookup
                if (test.size() == 0)
                    repository.save(new Jokes(null, joke)); // JPA save
            }
        };
    }
}
