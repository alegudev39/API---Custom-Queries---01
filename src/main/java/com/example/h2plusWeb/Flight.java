package com.example.h2plusWeb;

import jakarta.persistence.*;

@Entity
public class Flight {

    @Id
    @GeneratedValue
    private Long id;

    private String description;
    private String fromAirport;
    private String toAirport;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    public Flight() {

    }

    public Flight(String description, String fromAirport, String toAirport, FlightStatus status) {
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }
}