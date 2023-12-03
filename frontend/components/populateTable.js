import deleteUser from "../httpRequest/deleteUser.js";
import updateUser from "./updateUser.js"

const tableBody = document.getElementById('tableBody');

export default function populateTable(students){

    tableBody.innerHTML = null;
    

    // Create table rows and cells for each student
    // ... (existing code for creating table rows and cells)
    // Attach event listeners for update and delete buttons
    
    students.forEach((student, index) => {
        const row = document.createElement('tr');

        const th1 = document.createElement('th');
        const cell2 = document.createElement('td');
        const cell3 = document.createElement('td');
        const cell4 = document.createElement('td');
        const cell5 = document.createElement('td');
        const cell6 = document.createElement('td');
        
        const deleteButton = document.createElement('button')
        const updateButton = document.createElement('button')

        th1.textContent = index+1;
        cell2.textContent = student.studentId;
        cell3.textContent = student.name
        cell4.textContent =  student.studentCode
        cell5.textContent = student.enrollmentDate
        cell6.textContent = student.major
        
        

        deleteButton.textContent = "Delete"
        updateButton.textContent = "Update"
        deleteButton.classList.add("btn");
        deleteButton.classList.add("btn-primary")
          
        updateButton.classList.add("btn")
        updateButton.classList.add("btn-danger")
        deleteButton.addEventListener('click', async () => {
            try {
                const response = await deleteUser(student.studentId);
              } catch (error) {
                console.error('Error deleting user:', error);
              }
        }); // Call delete function on click

        updateButton.addEventListener('click', ()=>{
          updateUser(student)
        });
        
        row.appendChild(th1);
        row.appendChild(cell2);
        row.appendChild(cell3);
        row.appendChild(cell4);
        row.appendChild(cell5);
        row.appendChild(cell6);
        row.appendChild(updateButton);
        row.appendChild(deleteButton);

        

        tableBody.appendChild(row);

      });
}
