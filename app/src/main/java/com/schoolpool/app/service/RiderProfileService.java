package com.schoolpool.app.service;

import com.schoolpool.app.entities.RiderProfile;
import com.schoolpool.app.repository.RiderProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiderProfileService {

    @Autowired
    private RiderProfileRepository riderProfileRepository;

    public RiderProfile saveRiderProfile(RiderProfile riderProfile) {
        return riderProfileRepository.save(riderProfile);
    }


}
