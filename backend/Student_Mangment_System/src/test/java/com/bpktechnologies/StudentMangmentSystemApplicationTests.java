package com.bpktechnologies;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.bpktechnologies.entity.Student;
import com.bpktechnologies.repository.StudentRepository;
import com.bpktechnologies.services.StudentServiceImplements;

@SpringBootTest
class StudentMangmentSystemApplicationTests {

	
		@Mock
	    private StudentRepository studentRepository;

	    @InjectMocks
	    private StudentServiceImplements studentService;

	    /**
	     * Initialization before each test to set up Mockito-Testing.
	     */
	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    /**
	     * Test to verify adding a valid student and getting the added student details.
	     */
	    @Test
	    public void givenValidStudent_whenAddStudent_thenReturnAddedStudent() {
	        // Given
	        Student student = new Student();
	        student.setName("Akhtar Ansari");
	        student.setMajor("Java Backend Developer");
	        student.setEnrollmentDate(LocalDate.now());

	        // Mocking behavior of the repository
	        Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenReturn(student);

	        // When
	        Student addedStudent = studentService.addStudent(student);

	        // Then
	        Assertions.assertNotNull(addedStudent);
	        Assertions.assertEquals("Akhtar Ansari", addedStudent.getName());
	        // Add more assertions based on your scenario
	    }

	    /**
	     * Test to verify retrieving all existing students from the repository.
	     */
	    @Test
	    public void givenStudentsExist_whenGetAllStudents_thenReturnAllStudents() {
	        // Given
	        Mockito.when(studentRepository.findAll()).thenReturn(Arrays.asList(new Student(), new Student()));

	        // When
	        List<Student> students = studentService.getAllStudents();

	        // Then
	        Assertions.assertEquals(2, students.size());
	        // Add more assertions based on your scenario
	    }

	    /**
	     * Test to verify retrieving a student by a valid student ID.
	     */
	    @Test
	    public void givenValidStudentId_whenGetStudentById_thenReturnStudent() {
	        // Given
	        Student student = new Student();
	        student.setStudentId(1L);
	        student.setName("Akhtar Ansari");

	        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

	        // When
	        Student retrievedStudent = studentService.getStudentById(1L);

	        // Then
	        Assertions.assertNotNull(retrievedStudent);
	        Assertions.assertEquals("Akhtar Ansari", retrievedStudent.getName());
	        // Add more assertions based on your scenario
	    }

}
