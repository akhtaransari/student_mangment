package com.bpktechnologies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bpktechnologies.entity.Student;
import com.bpktechnologies.services.StudentServiceInterface;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Valid
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {
		
    @Autowired
    StudentServiceInterface studentServiceInterface;

    /**
     * End-point to add a new student.
     * URL: http://your-domain-or-ip.com/api/students/add
     */
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        log.info("Adding a new student: {}", student.getName());
        return new ResponseEntity<>(studentServiceInterface.addStudent(student), HttpStatus.ACCEPTED);
    }

    /**
     * End-point to retrieve all students.
     * URL: http://your-domain-or-ip.com/api/students/all
     */
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        log.info("Fetching all students");
        return new ResponseEntity<>(studentServiceInterface.getAllStudents(), HttpStatus.OK);
    }

    /**
     * End-point to retrieve a specific student by ID.
     * URL: http://your-domain-or-ip.com/api/students/find/{studentId}
     */
    @GetMapping("/find/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        log.info("Fetching student with ID: {}", studentId);
        return new ResponseEntity<>(studentServiceInterface.getStudentById(studentId), HttpStatus.OK);
    }

    /**
     * End-point to update a student's details.
     * URL: http://your-domain-or-ip.com/api/students/update/{studentId}
     */
    @PutMapping("/update/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody Student updatedStudent) {
        log.info("Updating student with ID: {}", studentId);
        return new ResponseEntity<>(studentServiceInterface.updateStudent(studentId, updatedStudent), HttpStatus.OK);
    }

    /**
     * End-point to delete a student by ID.
     * URL: http://your-domain-or-ip.com/api/students/delete/{studentId}
     */
    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) {
        log.info("Deleting student with ID: {}", studentId);
        return new ResponseEntity<>(studentServiceInterface.deleteStudent(studentId), HttpStatus.ACCEPTED);
    }
}
