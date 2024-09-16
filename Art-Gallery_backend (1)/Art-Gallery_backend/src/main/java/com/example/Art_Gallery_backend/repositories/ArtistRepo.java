package com.example.Art_Gallery_backend.repositories;

import com.example.Art_Gallery_backend.models.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepo extends MongoRepository<Artist,String> {
    Optional<Artist> findByUsername(String username);
}
