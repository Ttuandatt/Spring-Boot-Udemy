package com.example.practiceSpringMVC.model;

import jakarta.validation.constraints.*;

import java.util.List;

public class Student {
    @NotNull(message = "First name is required")
    @Size(min=1, message = "First name must be at least 1 character long")
    private String firstName;
    @NotNull(message = "Last name is required")
    @Size(min=1, message = "Last name must be at least 1 character long")
    private String lastName;
    private String country;
    private String favoriteLanguage;
    private List<String> favoriteOS;
    @Min(value=18, message = "Age must be greater than 18") // Minimum age validation
    @Max(value = 200, message = "Age must be less than 200") // Maximum age validation
    private int age;
    @Pattern(regexp = "[a-zA-Z0-9]{5}", message = "Postal code must be exactly 5 alphanumeric characters") // This regex pattern ensures that the postal code consists of exactly 5 alphanumeric characters (letters and digits).)
    private String postalCode;


    // Constructors
    public Student() {
        // no-arg constructor
    }

    public Student(String firstName, String lastName, String country, String favoriteLanguage, List<String> favoriteOS, int age, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.favoriteLanguage = favoriteLanguage;
        this.favoriteOS = favoriteOS;
        this.age = age;
        this.postalCode = postalCode;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public List<String> getFavoriteOS() {
        return favoriteOS;
    }

    public void setFavoriteOS(List<String> favoriteOS) {
        this.favoriteOS = favoriteOS;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
