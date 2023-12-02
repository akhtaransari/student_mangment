package com.bpktechnologies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpktechnologies.entity.Student;
import com.bpktechnologies.exceptions.StudentException;
import com.bpktechnologies.repository.StudentRepository;

@Service
public class StudentServiceImplements implements StudentServiceInterface {

    @Autowired
    StudentRepository studentRepository;

    /**
     * Adds a new student to the database.
     *
     * @param student The student object to add.
     * @return The added student.
     */
    @Override
    public Student addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student object cannot be null");
        }
        return studentRepository.save(student);
    }

    /**
     * Retrieves a list of all students.
     *
     * @return List of all students.
     * @throws StudentException if no users are found.
     */
    @Override
    public List<Student> getAllStudents() {
        List<Student> allStudents = studentRepository.findAll();
        if (allStudents.isEmpty()) {
            throw new StudentException("No users found");
        }
        return allStudents;
    }

    /**
     * Retrieves a specific student by their ID.
     *
     * @param id The ID of the student to retrieve.
     * @return The student with the given ID.
     * @throws StudentException if the student with the given ID is not found.
     */
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentException("Student with id " + id + " not found"));
    }

    /**
     * Updates details of an existing student.
     *
     * @param id              The ID of the student to update.
     * @param updatedStudent The updated student object.
     * @return The updated student details.
     * @throws StudentException if the student with the given ID is not found.
     */
    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        if (updatedStudent == null) {
            throw new IllegalArgumentException("Updated student object cannot be null");
        }
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentException("Student with id " + id + " not found"));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setMajor(updatedStudent.getMajor());
        existingStudent.setEnrollmentDate(updatedStudent.getEnrollmentDate());

        return studentRepository.save(existingStudent);
    }

    /**
     * Deletes a student from the database by their ID.
     *
     * @param id The ID of the student to delete.
     * @return The deleted student.
     * @throws StudentException if the student with the given ID is not found.
     */
    @Override
    public String deleteStudent(Long id) {
        Student studentToDelete = studentRepository.findById(id)
        		.orElseThrow(
        				()-> new StudentException("Student with id " + id + " not found"));
        studentRepository.delete(studentToDelete);        
        return "User With id "+id+ " deleted succesfully";
    }

}
