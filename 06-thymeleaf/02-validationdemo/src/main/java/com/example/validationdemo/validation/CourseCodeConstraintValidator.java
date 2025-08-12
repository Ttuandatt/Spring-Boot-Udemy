package com.example.validationdemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        this.coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

        boolean result;

        // Check if theCode is null or empty
        if (theCode == null || theCode.isEmpty()) {
            return true; // If theCode is null or empty, we consider it valid (no validation error)
        }else{
            // Check if theCode starts with the specified course prefix
            result = theCode.startsWith(coursePrefix);
        }

        return result;
    }
}
