package com.example.h2plusWeb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @PostMapping("/provision")
    public List<Flight> provisionFlights() {
        Random random = new Random();
        List<Flight> flights = IntStream.range(0, 50).mapToObj(i -> new Flight(
                generateRandomString(random),
                generateRandomString(random),
                generateRandomString(random),
                FlightStatus.ONTIME
        )).collect(Collectors.toList());

        return flightRepository.saveAll(flights);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    private String generateRandomString(Random random) {
        return random.ints(97, 123)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
