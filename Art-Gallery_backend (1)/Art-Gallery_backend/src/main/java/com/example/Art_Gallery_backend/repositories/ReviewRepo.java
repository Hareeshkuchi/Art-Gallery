package com.example.Art_Gallery_backend.repositories;

import com.example.Art_Gallery_backend.models.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepo extends MongoRepository<Review,String> {
}
