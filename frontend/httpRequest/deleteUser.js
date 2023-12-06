import alert from '../components/alert.js';
import getAllStudents from './getAllStudents.js';
import populateTable from '../components/populateTable.js';

const apiUrl = "https://akhtar.webpoint.co.in";

export default async function deleteUser(userId) {
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
      alert('User deleted successfully!');
      getAllStudents(apiUrl)
      .then(data => {
          populateTable(data);
      })
      .catch(error => {
          console.error('Error fetching data:', error);
      });

    } else {
      throw new Error('User deletion failed.');
    }
  } catch (error) {
    console.error('An error occurred during deletion:', error);
    throw error; // Re-throw the error to maintain consistency
  }
}
