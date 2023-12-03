const apiUrl = 'http://localhost:8080';
import alert from "../alert";

export default function addUser(){
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
        alert('Student Saved Successfully');
    })
    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
        // Handle error scenario
    });
}