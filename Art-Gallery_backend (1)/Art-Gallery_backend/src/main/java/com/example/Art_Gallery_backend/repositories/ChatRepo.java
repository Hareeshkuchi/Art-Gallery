package com.example.Art_Gallery_backend.repositories;

import com.example.Art_Gallery_backend.models.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepo extends MongoRepository<Chat,String> {
    List<Chat> findBySenderIdOrReceiverId(String senderId, String receiverId);
}
