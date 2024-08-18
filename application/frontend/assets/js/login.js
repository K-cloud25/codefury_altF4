document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const userType = document.querySelector('input[name="user-type"]:checked');
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    if (userType && email && password) {
        console.log(`Logged in as ${userType.value}`);
        console.log(`Email: ${email}`);
        console.log(`Password: ${password}`);
        alert(`Logged in as ${userType.value}`);
    } else {
        alert('Please fill in all fields and select a user type');
    }
});
