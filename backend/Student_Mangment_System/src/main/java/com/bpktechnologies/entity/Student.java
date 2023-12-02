package com.bpktechnologies.entity;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
	
	@NotEmpty(message = "Student id is required")
	private Long studentCode;

    @NotEmpty(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotEmpty(message = "Major is required")
    private String major;

    @NotNull(message = "Enrollment date is required")
    private LocalDate enrollmentDate;
   
}
