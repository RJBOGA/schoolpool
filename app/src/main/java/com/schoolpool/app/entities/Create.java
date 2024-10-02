package com.schoolpool.app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import javax.validation.constraints.NotEmpty;


@Document(collection = "users")  // Specify the MongoDB collection name
public class Create {

    @Id
    private String id;  // Use String for MongoDB IDs

    //@NotEmpty(message = "First name is required")
    private String fname;

    private String lname;

    private String phone;

    private String emailid;

    private String password;

    @JsonProperty("isRider")
    public boolean isRider() {
        return isRider;
    }

    private boolean isRider; // Indicates if the user is a rider

    public void setRider(boolean rider) {
        isRider = rider;
    }


    private RiderProfile riderProfile;

    public RiderProfile getRiderProfile() {
        return riderProfile;
    }

    public void setRiderProfile(RiderProfile riderProfile) {
        this.riderProfile = riderProfile;
    }


    // Constructors, getters, and setters
    public Create() {
    }

    public Create(String fname, String lname, String phone, String emailid, String password, boolean isRider) {
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.emailid = emailid;
        this.password = password;
        this.isRider = isRider;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
