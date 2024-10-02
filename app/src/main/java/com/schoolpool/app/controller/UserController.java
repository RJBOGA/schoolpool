package com.schoolpool.app.controller;

import com.schoolpool.app.entities.Create;
import com.schoolpool.app.entities.RiderProfile;
import com.schoolpool.app.repository.CreateRepository;
import com.schoolpool.app.repository.RiderProfileRepository;
import com.schoolpool.app.response.ApiResponse;
import com.schoolpool.app.service.CreateService;
import com.schoolpool.app.service.RiderProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")  // Base URL for user-related requests
public class UserController {

    @Autowired
    private CreateService createService;

    @Autowired
    private CreateRepository createRepository;

    @Autowired
    private RiderProfileService riderProfileService;

    @Autowired
    private RiderProfileRepository riderProfileRepository;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Create>> registerUser(@RequestBody Create user) {
        if (createRepository.findByEmailid(user.getEmailid()).isPresent()) {
            return ResponseEntity.badRequest().body(new ApiResponse<>(false, "Email is already in use.", null));
        }

        Create newUser = createService.registerUser(user);
        System.out.println("outside"+ user.isRider());

        if (user.isRider()) {
            System.out.println("inside"+ user);
            RiderProfile riderProfile = user.getRiderProfile();
            if (riderProfile == null || riderProfile.getAddress() == null || riderProfile.getCarModel() == null || riderProfile.getDriversLicenseNumber() == null) {
                return ResponseEntity.badRequest().body(new ApiResponse<>(false, "Rider-specific fields are required.", null));
            }
            riderProfile.setEmailid(newUser.getEmailid()); // Link rider profile with user via emailID
            riderProfileService.saveRiderProfile(riderProfile);
        }

        ApiResponse<Create> response = new ApiResponse<>(true, "User registered successfully.", newUser);
        return ResponseEntity.ok(response);
    }
}
