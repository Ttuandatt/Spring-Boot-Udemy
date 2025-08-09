package com.example.validationdemo.model;

import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "Last name is required")
    @Size(min=1, message = "Last name must be at least 1 character long")
    private String lastName;
    @Min(value=0, message = "Age must be >0")   // Minimum
    @Max(value=200, message = "Age must be < 200")
    private int age;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 alphanumeric characters are allowed") // regexp = "^[a-zA-Z0-9]{5}": // This regex pattern ensures that the postal code consists of exactly 5 alphanumeric characters (letters and digits).
    private String postalCode;

    // Constructors
    public Customer() {
    }
    public Customer(String firstName, String lastName, int age, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
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
