package com.example.validationdemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // Explanation: This annotation specifies that the CourseCodeConstraintValidator class will be used to validate the annotated field or method.
@Target({ElementType.METHOD, ElementType.FIELD})    // Explanation: This annotation specifies that the CourseCode annotation can be applied to methods and fields.
@Retention(RetentionPolicy.RUNTIME)                 // Explanation: This annotation specifies that the CourseCode annotation will be retained at runtime, allowing it to be accessed via reflection during validation.
public @interface CourseCode {

    // define default course code
    public String value() default "LUV"; // Explanation: This defines a default value for the course code, which is "LUV". If no value is provided when the annotation is used, this default will be applied.

    // define default error message
    public String message() default "must start with LUV"; // Explanation: This defines a default error message that will be used if the validation fails. If the course code does not start with "LUV", this message will be displayed.

    // define default groups
    public Class<?>[] groups() default {}; // Explanation: This allows the annotation to be associated with validation groups, which can be used to group constraints together for different validation scenarios.

    // define default payloads
    public Class<? extends Payload>[] payload() default {}; // Explanation: This allows the annotation to carry additional metadata (payload) that can be used by validation clients to provide more context about the validation. It is typically used for custom error handling or reporting.
}
