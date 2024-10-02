package com.schoolpool.app.repository;

import com.schoolpool.app.entities.PostedRides;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RidePostRepository extends MongoRepository<PostedRides, String> {
    List<PostedRides> findByEmailid(String emailid);
    // Custom query methods if necessary
}

