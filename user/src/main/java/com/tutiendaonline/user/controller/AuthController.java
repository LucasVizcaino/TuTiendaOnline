package com.tutiendaonline.user.controller;

import com.tutiendaonline.user.auth.AuthenticationRequest;
import com.tutiendaonline.user.entity.User;
import com.tutiendaonline.user.service.AuthenticationResponse;
import com.tutiendaonline.user.entity.RegisterRequest;
import com.tutiendaonline.user.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authentication(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/costumer-{id}")
    public ResponseEntity<User> getUserId(@PathVariable long id){
        return ResponseEntity.ok(service.findUserById(id));
    }
}