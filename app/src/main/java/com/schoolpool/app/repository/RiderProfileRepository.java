package com.schoolpool.app.repository;

import com.schoolpool.app.entities.RiderProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface RiderProfileRepository extends MongoRepository<RiderProfile, String> {

}
