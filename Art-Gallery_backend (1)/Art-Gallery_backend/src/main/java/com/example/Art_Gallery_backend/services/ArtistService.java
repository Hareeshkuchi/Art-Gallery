package com.example.Art_Gallery_backend.services;

import com.example.Art_Gallery_backend.models.Artist;
import com.example.Art_Gallery_backend.models.User;
import com.example.Art_Gallery_backend.repositories.ArtistRepo;
import com.example.Art_Gallery_backend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepo artistRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Artist registerArtist(Artist artist) {
        // Check if the username is already taken
        Optional<Artist> existingArtist = artistRepo.findByUsername(artist.getUsername());
        if (existingArtist.isPresent()) {
            throw new IllegalArgumentException("Username already taken");
        }

        // Encrypt the password before saving
        artist.setPassword(passwordEncoder.encode(artist.getPassword()));
        return artistRepo.save(artist);
    }

    public Optional<Artist> login(String username, String password) {
        Optional<Artist> artist = artistRepo.findByUsername(username);
        if (artist.isPresent()) {
            // Check if the password matches
            if (passwordEncoder.matches(password, artist.get().getPassword())) {
                return artist;
            }
        }
        return Optional.empty();
    }
    public void addChatToArtist(String artistId, String chatId) {
        Artist artist = artistRepo.findById(artistId).orElseThrow();
        if (!artist.getChatIds().contains(chatId)) {
            artist.getChatIds().add(chatId);
            artistRepo.save(artist);
        }
    }
}
