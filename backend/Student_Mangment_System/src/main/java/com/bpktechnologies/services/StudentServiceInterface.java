package com.bpktechnologies.services;

import java.util.List;

import com.bpktechnologies.entity.Student;

/**
 * StudentServiceInterface outlines the methods to manage student data.
 */
public interface StudentServiceInterface {
    
    /**
     * Adds a new student to the system.
     * 
     * @param student The student object to be added.
     * @return The added student.
     */
    Student addStudent(Student student);
    
    /**
     * Retrieves a list of all students.
     * 
     * @return A list containing all students.
     */
    List<Student> getAllStudents();
    
    /**
     * Retrieves details of a specific student by ID.
     * 
     * @param id The unique identifier of the student.
     * @return The student details.
     */
    Student getStudentById(Long id);
    
    /**
     * Updates the details of an existing student.
     * 
     * @param id The unique identifier of the student to be updated.
     * @param updatedStudent The updated student information.
     * @return The updated student details.
     */
    Student updateStudent(Long id, Student updatedStudent);
    
    /**
     * Deletes a student from the system.
     * 
     * @param id The unique identifier of the student to be deleted.
     * @return The String deleted status.
     */
    String deleteStudent(Long id);
}

