package com.example.Art_Gallery_backend.repositories;

import com.example.Art_Gallery_backend.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User,String> {
    Optional<User> findByUsername(String UserName);
}
