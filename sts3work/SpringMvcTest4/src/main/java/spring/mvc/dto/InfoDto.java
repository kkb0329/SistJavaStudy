package spring.mvc.dto;

import java.util.Arrays;

public class InfoDto {
    private String name;
    private String color;
    private String[] hobby;
    private String language;

    // Getters & Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String[] getHobby() {
        return hobby;
    }
    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "InfoDto [name=" + name + ", color=" + color + ", hobby=" + Arrays.toString(hobby) + ", language=" + language + "]";
    }
}

