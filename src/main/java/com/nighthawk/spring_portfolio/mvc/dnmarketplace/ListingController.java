package com.nighthawk.spring_portfolio.mvc.dnmarketplace;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListingController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/listings")
    public Listing listing(@RequestParam(value = "name", defaultValue = "newlisting") String name) {
        return new Listing(counter.incrementAndGet(), name);
    }
}
