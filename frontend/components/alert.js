export default function alert(message) {
    const alertDiv = document.createElement('div');
    alertDiv.className = 'alert alert-primary fixed-top';
    alertDiv.role = 'alert';
    alertDiv.textContent = message;

    // Append the alert to the body
    document.body.appendChild(alertDiv);

    // Remove the alert after a certain duration (e.g., 5 seconds)
    setTimeout(function () {
        document.body.removeChild(alertDiv);
    }, 3000);
}