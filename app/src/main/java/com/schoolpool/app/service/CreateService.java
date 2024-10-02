package com.schoolpool.app.service;


import com.schoolpool.app.entities.Create;
import com.schoolpool.app.repository.CreateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateService {

    @Autowired
    private CreateRepository createRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;  // Autowire the BCryptPasswordEncoder

    // Method to register a new user
    public Create registerUser(Create user) {
        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return createRepository.save(user);
    }

    public Optional<Create> findByEmailid(String emailid) {
        return createRepository.findByEmailid(emailid);
    }
}
