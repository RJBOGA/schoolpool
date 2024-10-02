package com.schoolpool.app.controller;

import com.schoolpool.app.entities.PostedRides;
import com.schoolpool.app.response.ApiResponse;
import com.schoolpool.app.service.RidePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")  // Base URL for ride-related requests
public class RidesController {

    @Autowired
    private RidePostService ridePostService;

    @PostMapping("/post")
    public ResponseEntity<ApiResponse<PostedRides>> postRide(@RequestBody PostedRides postedRides) {
        System.out.println("post");
        PostedRides newPostedRides = ridePostService.createRidePost(postedRides);
        ApiResponse<PostedRides> response = new ApiResponse<>(true, "Ride posted successfully.", newPostedRides);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{emailid}")
    public ResponseEntity<ApiResponse<List<PostedRides>>> getRidesByUser(@PathVariable String emailid) {
        List<PostedRides> rides = ridePostService.findRidesByEmailId(emailid);
        System.out.println(emailid);
        System.out.println(rides);
        return ResponseEntity.ok(new ApiResponse<>(true, "Rides fetched successfully.", rides));
    }
}
