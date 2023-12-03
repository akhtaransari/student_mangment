export default function getAllStudents(params) {
       return fetch(`${params}/api/students/all`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(apiData => {
            // Process the fetched student details as needed
            return apiData;
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });

}
