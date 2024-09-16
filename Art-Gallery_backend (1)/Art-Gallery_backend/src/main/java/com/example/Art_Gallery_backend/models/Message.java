package com.example.Art_Gallery_backend.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {
    private String senderId;
    private String content;
    private LocalDateTime timestamp;

    // Constructor, Getters, and Setters
    public Message(String senderId, String content) {
        this.senderId = senderId;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
}
