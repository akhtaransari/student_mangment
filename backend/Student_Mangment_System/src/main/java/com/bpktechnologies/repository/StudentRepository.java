package com.bpktechnologies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpktechnologies.entity.Student;

/**
 * Repository interface for managing Student entities.
 * Extends JpaRepository to leverage built-in CRUD functionalities.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    // This interface inherits CRUD methods from JpaRepository for Student entity and primary key Long
}
