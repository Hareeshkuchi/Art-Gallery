package com.example.Art_Gallery_backend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "artists")
public class Artist {

    @Id
    private String id;
    private String username;
    private String password;
    private String category;
    private List<String> arts; // IDs of the artist's arts
    private List<String> chatIds; // List of chat IDs
    private List<Review> reviews;
    private String profilePictureBase64; // Profile picture in Base64 format
    private double rating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public List<String> getChatIds() {
        return chatIds;
    }

    public void setChatIds(List<String> chatIds) {
        this.chatIds = chatIds;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getArts() {
        return arts;
    }

    public void setArts(List<String> arts) {
        this.arts = arts;
    }

    public String getProfilePictureBase64() {
        return profilePictureBase64;
    }

    public void setProfilePictureBase64(String profilePictureBase64) {
        this.profilePictureBase64 = profilePictureBase64;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReviews(Review review) {
        reviews.add(review);
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}


