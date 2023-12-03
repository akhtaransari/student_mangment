import alert from "../components/alert.js";

export default function updateUser({studentId, studentCode, name , major , enrollmentDate}){
    window.scrollTo({ top: 0, behavior: 'smooth' });

    document.getElementById('validationCustom01').value = name
    document.getElementById('validationCustom02').value = major;
    document.getElementById('validationCustom03').value = enrollmentDate;
    document.getElementById('validationCustom05').value = studentCode;

    document.querySelector('.submit-btn').textContent = "Update";
    document.querySelector('.submit-btn').classList.add("btn-dark")

    localStorage.setItem("id",studentId);
    alert("Edit Fileds to Update Student")


}