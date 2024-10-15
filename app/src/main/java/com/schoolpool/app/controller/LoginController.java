package com.schoolpool.app.controller;

import com.schoolpool.app.entities.Login;
import com.schoolpool.app.response.ApiResponse;
import com.schoolpool.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody Login login) {
        // Authenticate user credentials
        System.out.println(login.getMailID() + " tried to login with credentials");
        System.out.println(login);
        boolean isAuthenticated = loginService.authenticate(login.getMailID(), login.getPassword());

        if (isAuthenticated) {
            // Return success message as a structured response
            ApiResponse<String> response = new ApiResponse<>(true, "Login successful", null);
            System.out.println("Login successful");
            return ResponseEntity.ok(response);
        } else {
            // Return error message in structured response
            ApiResponse<String> response = new ApiResponse<>(false, "Invalid credentials", null);
            System.out.println("Invalid credentials");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
