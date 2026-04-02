package com.klu.springexception_9.controller;

import com.klu.springexception_9.exception.InvalidInputException;
import com.klu.springexception_9.exception.StudentNotFoundException;
import com.klu.springexception_9.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        int studentId;

        try {
            studentId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid ID format. Please enter a number.");
        }

        if (studentId <= 0) {
            throw new InvalidInputException("ID must be positive.");
        }

        if (studentId != 1) {
            throw new StudentNotFoundException("Student not found with ID: " + studentId);
        }

        return new Student(1, "Mohit");
    }
}