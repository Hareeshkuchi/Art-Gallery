package com.example.Art_Gallery_backend.models;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "reviews")
public class Review {
    private String userId;
    private String comment;
    private double rating;
    private LocalDateTime reviewDate;
}

