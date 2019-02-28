package com.example.krishanroy.unit_04_assessment.model;

public class Messages {
    private String animal;
    private String image;
    private String wiki;

    public Messages(String animal, String image, String wiki) {
        this.animal = animal;
        this.image = image;
        this.wiki = wiki;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }
}
