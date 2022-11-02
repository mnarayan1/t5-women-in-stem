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
            final Jokes[] jokesArray = {
                    new Jokes(null, "PE Lock", 10, "Bob Joe",
                            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1200px-Cat03.jpg"),
                    new Jokes(null, "Fruit Bars", 5, "John",
                            "https://target.scene7.com/is/image/Target/GUEST_4ea32ffb-e7e8-4968-9310-b4b304dc78de"),
                    new Jokes(null, "AP Calculus BC Prep Book", 15, "Mike",
                            "https://images-na.ssl-images-amazon.com/images/I/71nx1Hezu6L._AC_UL210_SR210,210_.jpg"),
                    new Jokes(null, "Used Mac *NOT CLICKBAIT*", 100, "Pranavi",
                            "https://i.insider.com/596cf74fa47cb51c008b4b2f?width=1074&format=jpeg"),
                    new Jokes(null, "Tutoring Services", 100000, "Mads",
                            "https://clipartix.com/wp-content/uploads/2017/07/Top-pencil-for-clip-art-free-clipart-image.png"),
                    new Jokes(null, "TI Nspire Calculator", 600, "Meena",
                            "https://m.media-amazon.com/images/I/61c8jg5GogL.jpg")
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
