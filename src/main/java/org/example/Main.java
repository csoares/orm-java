package org.example;

import org.example.model.Student;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        // Create a new student
        studentService.createStudent("John Doe2", "john.doe@example.com");

        // Find a student
        Student student = studentService.findStudent(1L);

        // Update a student
        studentService.updateStudent(7L, "Jane Doe3", "jane.doe@example.com");

        // Delete a student
        studentService.deleteStudent(1L);
    }
}
