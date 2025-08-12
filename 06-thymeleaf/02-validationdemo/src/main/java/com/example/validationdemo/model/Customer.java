package com.example.validationdemo.model;

import com.example.validationdemo.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "Last name is required")
    @Size(min=1, message = "Last name must be at least 1 character long")
    private String lastName;
    @NotNull(message = "Age is required") // @NotNull: This annotation ensures that the age field cannot be null.
    @Min(value=0, message = "Age must be >0")   // Minimum
    @Max(value=200, message = "Age must be < 200")
    private Integer age;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 alphanumeric characters are allowed") // regexp = "^[a-zA-Z0-9]{5}": // This regex pattern ensures that the postal code consists of exactly 5 alphanumeric characters (letters and digits).
    private String postalCode;

    @NotNull(message = "Course code is required") // @NotNull: This annotation ensures that the courseCode field cannot be null.
    @CourseCode(value = "TOPS", message = "must start with TOPS") // @CourseCode: This custom annotation checks that the courseCode starts with the specified prefix "TOPS". If it does not, the provided error message will be displayed.
    private String courseCode;

    // Constructors
    public Customer() {
    }
    public Customer(String firstName, String lastName, Integer age, String postalCode, String courseCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.postalCode = postalCode;
        this.courseCode = courseCode;
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
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

}
