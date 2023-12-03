import alert from "../components/alert.js";

const apiUrl = 'http://localhost:8080';
const submitBtn = document.querySelector('.submit-btn');

export default function updateUserReqeust(studentId, updatedStudent) {
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
        alert('User Updated Succesfully')
    })
    .catch(error => {
        console.error('Error updating student:', error.message);
    });
    }