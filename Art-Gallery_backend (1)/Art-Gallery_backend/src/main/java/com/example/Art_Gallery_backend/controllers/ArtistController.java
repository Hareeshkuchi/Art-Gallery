package com.example.Art_Gallery_backend.controllers;

import com.example.Art_Gallery_backend.models.Artist;
import com.example.Art_Gallery_backend.models.User;
import com.example.Art_Gallery_backend.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    // Registration endpoint
    @PostMapping("/register")
    public ResponseEntity<?> registerArtist(@RequestBody Artist artist) {
        try {
            Artist registeredArtist = artistService.registerArtist(artist);
            return ResponseEntity.ok(registeredArtist); // Return the registered user
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> loginArtist(@RequestParam String username, @RequestParam String password) {
        Optional<Artist> artist = artistService.login(username, password);
        if (artist.isPresent()) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
