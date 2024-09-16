package com.example.Art_Gallery_backend.repositories;

import com.example.Art_Gallery_backend.models.Art;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtRepo extends MongoRepository<Art,String> {

}
