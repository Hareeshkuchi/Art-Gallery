package com.example.Art_Gallery_backend.services;

import com.example.Art_Gallery_backend.models.Chat;
import com.example.Art_Gallery_backend.models.Message;
import com.example.Art_Gallery_backend.repositories.ChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepo chatRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ArtistService artistService;

    public Chat createChat(String userId, String artistId) {
        Chat chat = new Chat();
        chat.setSenderId(userId);
        chat.setReceiverId(artistId);
        chat.setMessages(new ArrayList<>());
        Chat savedChat = chatRepository.save(chat);

        // Add the chat ID to both user and artist
        userService.addChatToUser(userId, savedChat.getId());
        artistService.addChatToArtist(artistId, savedChat.getId());

        return savedChat;
    }

    public Chat sendMessage(String chatId, String senderId, String content) {
        Optional<Chat> chatOptional = chatRepository.findById(chatId);
        if (chatOptional.isPresent()) {
            Chat chat = chatOptional.get();
            Message message = new Message(senderId, content);
            chat.getMessages().add(message);
            return chatRepository.save(chat); // Save updated chat
        }
        return null;
    }

    public List<Chat> getChatsForUserOrArtist(String userId) {
        return chatRepository.findBySenderIdOrReceiverId(userId, userId);
    }
}

