package com.example.Art_Gallery_backend.controllers;

import com.example.Art_Gallery_backend.models.Chat;
import com.example.Art_Gallery_backend.services.ChatService;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/start")
    public ResponseEntity<Chat> startChat(@RequestParam String userId, @RequestParam String artistId) {
        Chat chat = chatService.createChat(userId, artistId);
        return ResponseEntity.ok(chat);
    }

    @PostMapping("/{chatId}/send")
    public ResponseEntity<Chat> sendMessage(@PathVariable String chatId,
                                            @RequestParam String senderId,
                                            @RequestParam String content) {
        Chat chat = chatService.sendMessage(chatId, senderId, content);
        if (chat != null) {
            return ResponseEntity.ok(chat);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{userId}/get")
    public ResponseEntity<List<Chat>> getUserChats(@PathVariable String userId) {
        List<Chat> chats = chatService.getChatsForUserOrArtist(userId);
        return ResponseEntity.ok(chats);
    }
}

