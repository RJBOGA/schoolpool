package com.schoolpool.app.service;

import com.schoolpool.app.entities.Create;
import com.schoolpool.app.repository.CreateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private CreateRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean authenticate(String email, String password) {
        // Retrieve the user wrapped in an Optional
        Optional<Create> userOptional = userRepository.findByEmailid(email);

        // If user is present, verify the password
        if (userOptional.isPresent()) {
            Create user = userOptional.get();
            return passwordEncoder.matches(password, user.getPassword());
        }

        // If user is not present, authentication fails
        return false;
    }
}
