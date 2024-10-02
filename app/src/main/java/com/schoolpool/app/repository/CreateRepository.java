package com.schoolpool.app.repository;

import com.schoolpool.app.entities.Create;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CreateRepository extends MongoRepository<Create, String> {
    //Create findByEmailid(String emailid);
    Optional<Create> findByEmailid(String emailid);

}
