package com.example.mytesteditapplication;

import java.util.ArrayList;
import java.util.List;

class Recipe {

    private long id;
    private String name;
    private String category;
    private String description;
    private String imagePath;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

//    private ArrayList<Ingredient> ingredients;
//    private ArrayList<Direction> directions;
}
