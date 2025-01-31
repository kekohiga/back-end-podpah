package com.example.loginauthapi.model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "guests") // Define a coleção no MongoDB
public class Guest {

    @Id
    private String id;
    private String name;
    private String description;
    private String dayOfWeek;

    public Guest(String name, String description, String dayOfWeek) {
        this.name = name;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
// Getters e Setters
}