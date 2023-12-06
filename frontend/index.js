import getAllStudents from "./httpRequest/getAllStudents.js"
import populateTable  from "./components/populateTable.js";
import updateUserReqeust from "./httpRequest/updateUserRequest.js"
import alert from "./components/alert.js";

const apiUrl = "https://akhtar.webpoint.co.in";
const searchInput = document.querySelector('.form-control');
const searchButton = document.querySelector('.btn-outline-primary');
const submitBtn = document.querySelector('.submit-btn');
const cancelButton = document.querySelector('.cancel-btn');
const form = document.querySelector('.needs-validation');

// Event listener for search button
    searchButton.addEventListener("click",()=>{

    });

    // Fetch all students and populate the table on window load
    window.addEventListener('load', () => {
        getAllStudents(apiUrl)
        .then(data => {
            populateTable(data);
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
    });


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


        form.reset();
    });


    cancelButton.addEventListener('click', function (event) {
        form.reset();
        form.classList.remove('was-validated');
    });

    const searchForm = document.querySelector(".search-form");
console.log(searchButton)

searchForm.addEventListener("submit", (event) => {
    event.preventDefault(); // Prevent default form submission behavior
    event.stopPropagation();
    
    getAllStudents(apiUrl)
        .then(data => {
            const input =  document.getElementById("search-input");
            const filteredData = data.filter((el) => el.name.toLowerCase().includes(input.value));
            if (filteredData.length){
                populateTable(filteredData);
            }else {
                alert("no student found with "+input.value)
            }

            
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });

});
