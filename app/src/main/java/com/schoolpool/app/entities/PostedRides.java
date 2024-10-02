package com.schoolpool.app.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "postedRides")
public class PostedRides {

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndDestination() {
        return endDestination;
    }

    public void setEndDestination(String endDestination) {
        this.endDestination = endDestination;
    }

    public LocalDateTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(LocalDateTime timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public double getPickupRadius() {
        return pickupRadius;
    }

    public void setPickupRadius(double pickupRadius) {
        this.pickupRadius = pickupRadius;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(double pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String[] getPickupLocations() {
        return pickupLocations;
    }

    public void setPickupLocations(String[] pickupLocations) {
        this.pickupLocations = pickupLocations;
    }

    private String emailid;            // Email of the rider
    private String startLocation;      // Starting point
    private String endDestination;     // Destination point
    private LocalDateTime timeOfDeparture;    // Time of departure
    private double pickupRadius;       // Pickup radius in minutes or kilometers
    private int seatsAvailable;        // Number of available seats
    private double pricePerSeat;       // Optional price for each seat
    private String notes;              // Optional notes or comments (e.g., no smoking)
    private String[] pickupLocations;  // Array or List of preferred pickup locations

    // Constructors, getters, and setters

    public PostedRides() {}

    public PostedRides(String emailid, String startLocation, String endDestination, LocalDateTime timeOfDeparture, double pickupRadius,
                       int seatsAvailable, double pricePerSeat, String notes, String[] pickupLocations) {
        this.emailid = emailid;
        this.startLocation = startLocation;
        this.endDestination = endDestination;
        this.timeOfDeparture = timeOfDeparture;
        this.pickupRadius = pickupRadius;
        this.seatsAvailable = seatsAvailable;
        this.pricePerSeat = pricePerSeat;
        this.notes = notes;
        this.pickupLocations = pickupLocations;
    }

    // Getters and Setters for all fields
}

