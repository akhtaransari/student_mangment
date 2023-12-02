import  {getAllStudents}  from  './getAllStudents.js';
// import { updateUser } from './updateUser.js';
// import { deleteUser } from './deleteUser.js';
// import { updateUserRequest } from './updateUserRequest.js';

// Your event listeners, form handling, etc.




// Get form and add event listener for form submission

const apiUrl = "http://localhost:8080";
const tableBody = document.getElementById('tableBody');

const searchInput = document.querySelector('.form-control');
const searchButton = document.querySelector('.btn-outline-primary');


const submitBtn = document.querySelector('.submit-btn');
const cancelButton = document.querySelector('.cancel-btn');


searchButton.addEventListener("click",()=>{
   console.log(searchInput)
});

window.addEventListener('DOMContentLoaded', ()=>{
    getAllStudents(apiUrl,apiUrl)
});


// function getAllStudents() {
//     fetch(`${apiUrl}/api/students/all`)
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error('Network response was not ok');
//             }
//             return response.json();
//         })
//         .then(students => {
//             // Process the fetched student details as needed
//             populateTable(students);
            
//         })
//         .catch(error => {
//             console.error('There was a problem with the fetch operation:', error);
//         });
// }

function populateTable(students){

tableBody.innerHTML = null;
    
    
    students.forEach((student, index) => {
        const row = document.createElement('tr');

        const th = document.createElement('th');
        const cell1 = document.createElement('td');
        const cell2 = document.createElement('td');
        const cell3 = document.createElement('td');
        const cell4 = document.createElement('td');
        const cell5 = document.createElement('td');
        const cell6 = document.createElement('td');
        const deleteButton = document.createElement('button')
        const updateButton = document.createElement('button')

        th.textContent = index+1;
        cell1.textContent = student.studentId;
        cell2.textContent = student.name
        cell3.textContent =  student.studentCode
        cell4.textContent = student.enrollmentDate
        

        deleteButton.textContent = "Delete"
        updateButton.textContent = "Update"
        deleteButton.classList.add("btn");
        deleteButton.classList.add("btn-primary")
          
        updateButton.classList.add("btn")
        updateButton.classList.add("btn-danger")
        deleteButton.addEventListener('click', () => deleteUser(student.studentId)); // Call delete function on click

        updateButton.addEventListener('click', () => {
            window.scrollTo({ top: 0, behavior: 'smooth' });
            updateUser(student);
        });


        cell5.appendChild(updateButton)
        cell6.appendChild(deleteButton)
        row.appendChild(th);
        row.appendChild(cell1);
        row.appendChild(cell2);
        row.appendChild(cell3);
        row.appendChild(cell4);
        row.appendChild(cell5);
        row.appendChild(cell6);
        
        // deleteButton.addEventListener("click",deleteStudent);
        tableBody.appendChild(row);

      });
    }

    // Function to delete a user by ID using an API DELETE request
  async function deleteUser(userId) {

    try {
      const response = await fetch(`${apiUrl}/api/students/delete/${userId}`, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json',
          // Add any other headers as needed
        },
        // Optionally, add a request body if required by your API
        body: JSON.stringify({}),
      });
  
      if (response.ok) {
          showSuccessAlert('User deleted successfully!')
          getAllStudents();
      } 
    } catch (error) {
      console.error('An error occurred during deletion:', error);
      alert('An error occurred. Please try again later.');
    }
  }
  
  function updateUser({studentId, studentCode, name , major , enrollmentDate}){
    
        document.getElementById('validationCustom01').value = name
        document.getElementById('validationCustom02').value = major;
        document.getElementById('validationCustom03').value = enrollmentDate;
        document.getElementById('validationCustom05').value = studentCode;

        const student = {
            studentCode : document.getElementById('validationCustom05').value,
            name : document.getElementById('validationCustom01').value,
            major : document.getElementById('validationCustom02').value,
            enrollmentDate : document.getElementById('validationCustom03').value

        }

        submitBtn.textContent = "Update";
        submitBtn.classList.add("btn-dark");
        localStorage.setItem("id",studentId);

  }

    function updateUserReqeust(studentId, updatedStudent) {
    fetch(`${apiUrl}/api/students/update/${studentId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedStudent)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to update student');
        }
        return response.json();
    })
    .then(data => {
        localStorage.removeItem("id");
        submitBtn.textContent = "Submit";
        submitBtn.classList.remove("btn-dark");
        getAllStudents();
        showSuccessAlert('User Updated Succesfully')
    })
    .catch(error => {
        console.error('Error updating student:', error.message);
        // Handle error scenarios
    });
    }

    const form = document.querySelector('.needs-validation');

    form.addEventListener('submit', function (event) {
        event.preventDefault();
        event.stopPropagation();
        

        
        // Check form validity
        if (form.checkValidity() === false) {
            form.classList.add('was-validated');
            return;
        }
        
        // Get form values
        const studentName = document.getElementById('validationCustom01').value;
        const major = document.getElementById('validationCustom02').value;
        const enrollmentDate = document.getElementById('validationCustom03').value;
        const studentID = document.getElementById('validationCustom05').value;


        if (submitBtn.textContent == "Update"){
         
            const student = {
                name: studentName,
                major: major,
                enrollmentDate: enrollmentDate,
                studentID: studentID
            };

            updateUserReqeust(localStorage.getItem("id"),student);
            form.reset();

         return;   
        }

        // Create student object
        const student = {
            name: studentName,
            major: major,
            enrollmentDate: enrollmentDate,
            studentID: studentID
        };

        // Perform POST request to save student data
        fetch(`${apiUrl}/api/students/add`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(student)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            form.reset();
            showSuccessAlert('Student Saved Successfully');
            getAllStudents();
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
            // Handle error scenario
        });
    });


    cancelButton.addEventListener('click', function (event) {
        form.reset();
        form.classList.remove('was-validated');
    });


    function showSuccessAlert(message) {
        const alertDiv = document.createElement('div');
        alertDiv.className = 'alert alert-primary fixed-bottom';
        alertDiv.role = 'alert';
        alertDiv.textContent = message;
    
        // Append the alert to the body
        document.body.appendChild(alertDiv);
    
        // Remove the alert after a certain duration (e.g., 5 seconds)
        setTimeout(function () {
            document.body.removeChild(alertDiv);
        }, 3000);
    }


    function filterStudentsByStudentId(inputValue, studentArray) {
        const searchValue = inputValue.trim();
        if (!searchValue) return studentArray; // If search bar is empty, return all students
      
        const filteredStudents = studentArray.filter(student => {
          const id = student.studentId.toString(); // Convert studentId to string for comparison
          return id.includes(searchValue); // Check if the input value is part of the studentId
        });
      
        return filteredStudents;
      }
            
      