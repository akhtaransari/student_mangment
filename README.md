# Student Management System

## Overview
This project is a full-stack web application designed to manage student records efficiently. It includes features for adding, viewing, updating, and deleting student information. The system consists of both front-end and back-end components and utilizes APIs to interact with the database.

## Objective
The primary objective of this project is to create a seamless system that allows users to perform CRUD (Create, Read, Update, Delete) operations on student records. It aims to provide a user-friendly interface for managing student data effectively.

## Technologies Used
- Back-End:  Spring Boot
- Front-End: HTML , CSS ,BootStarp,  Vanilla JS
- Database:  MySQL

## Features
- Add new students with details like name, student ID, major, and enrollment date.
- View a list of all students in a grid format.
- Update student information.
- Delete students from the records.
- Integration of front-end with back-end services.
- Deployment using hosting platforms like Railway or Netlify for back-end and Netlify for the front-end.
- Optional: User authentication for system access.
- Optional: Search and filter capabilities to easily find students.

## Folder Structure
- `backend/`: Contains the code for the back-end/API.
- `frontend/`: Holds the code for the front-end application.

## Setup Instructions
1. Clone the repository: `git clone https://github.com/your-username/student-management-system.git`
2. Navigate to the backend folder and follow the backend setup instructions.
3. Navigate to the frontend folder and follow the frontend setup instructions.

## API Documentation
- API url: https://akhtar.webpoint.co.in
- API endpoints:
  - `POST /api/students/add`: Add a new student.
  - `GET /api/students/all`: Retrieve a list of all students.
  - `GET /api/students/find/:id`: Get details of a specific student.
  - `PUT /api/students/update/:id`: Update an existing student.
  - `DELETE /api/students/delete/:id`: Delete a student.

## Testing Student Management System

For robust testing and validation of the Student Management System, we've implemented a suite of test cases using Mockito within the Spring Boot framework.

### Purpose
The test suite ensures the correctness and reliability of key functionalities within the system.

### Test Cases

#### Adding a Valid Student
- **Scenario**: Adding a valid student and retrieving the added student's details.
- **Explanation**: This test verifies the successful addition of a student and confirms that the returned student's details match the expected values.

#### Retrieving All Students
- **Scenario**: Retrieving all existing students from the repository.
- **Explanation**: This test ensures that the system correctly retrieves all students and validates the count of retrieved students.

#### Retrieving a Student by ID
- **Scenario**: Retrieving a specific student by a valid student ID.
- **Explanation**: This test validates the functionality to fetch a student using their ID and confirms that the retrieved student's details match the expected values.

### Utilizing Mockito for Testing
Mockito is employed to simulate database interactions without impacting the actual database. This allows for controlled testing across various scenarios, enhancing the system's reliability.

Feel free to expand upon these test cases or include additional scenarios pertinent to the Student Management System.

## Deployment
1. Deploy the back-end application on own server. 
2. Deploy the front-end application on  own server.

## Contributors
- Akhtar Ansari (Java Full Stack Web Developer)
- 
## Acknowledgments
- Mention any resources, tutorials, or inspirations used during development.
