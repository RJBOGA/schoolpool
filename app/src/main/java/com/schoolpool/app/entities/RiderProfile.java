package com.schoolpool.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rider_details")  // MongoDB collection for rider profiles
public class RiderProfile {

    @Id
    private String id; // Unique ID for the rider profile
    private String emailid; // Reference to the user who owns this profile
    private String address;
    private String carModel;
    private String carYear;
    private String carLicensePlate;
    private String driversLicenseNumber;

    // Optional fields (e.g., car insurance, availability)
    private String insuranceProvider;
    private String insurancePolicyNumber;
    private int drivingExperience; // in years
    private String availability; // e.g., "Weekdays 9am-5pm"

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String userId) {
        this.emailid = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate;
    }

    public String getDriversLicenseNumber() {
        return driversLicenseNumber;
    }

    public void setDriversLicenseNumber(String driversLicenseNumber) {
        this.driversLicenseNumber = driversLicenseNumber;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    // Constructors (default and parameterized)

    public RiderProfile() {
    }

    public RiderProfile(String id, String emailid, String address, String carModel, String carYear, String carLicensePlate, String driversLicenseNumber, String insuranceProvider, String insurancePolicyNumber, int drivingExperience, String availability) {
        this.id = id;
        this.emailid = emailid;
        this.address = address;
        this.carModel = carModel;
        this.carYear = carYear;
        this.carLicensePlate = carLicensePlate;
        this.driversLicenseNumber = driversLicenseNumber;
        this.insuranceProvider = insuranceProvider;
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.drivingExperience = drivingExperience;
        this.availability = availability;
    }
}
