package com.schoolpool.app.service;

import com.schoolpool.app.entities.PostedRides;
import com.schoolpool.app.repository.RidePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RidePostService {

    @Autowired
    private RidePostRepository ridePostRepository;

    public PostedRides createRidePost(PostedRides postedRides) {
        return ridePostRepository.save(postedRides);
    }

    public List<PostedRides> findRidesByEmailId(String emailid) {
        return ridePostRepository.findByEmailid(emailid);
    }
}
