const form = document.getElementById("form");
const username = document.getElementById("username");
const email = document.getElementById("email");
const password = document.getElementById("password");
const confirmedPassword = document.getElementById("confirmedPassword");

form.addEventListener('submit', (e) => {
    e.preventDefault();
    validateInputFields();
});

function validateInputFields() {
    const usernameValue = username.value.trim();
    const emailValue = email.value.trim();
    const passwordValue = password.value.trim();
    const confirmedPasswordValue = confirmedPassword.value.trim();

    validateUsername(usernameValue);
    validateEmail(emailValue);
    validatePassword(passwordValue);
    validateConfirmedPassword(confirmedPasswordValue, passwordValue);
}

function validateUsername(usernameValue) {
    if (isValidUsername(usernameValue)) {
        setSuccessFor(username);
    }
    else {
        setErrorFor(username, 'Invalid username');
    }
}

function validateEmail(emailValue) {
    if (isValidEmail(emailValue)) {
        setSuccessFor(email);
    }
    else {
        setErrorFor(email, 'Invalid email');
    }
}

function validatePassword(passwordValue) {
    if (passwordValue !== "") {
        setSuccessFor(password);
    }
    else {
        setErrorFor(password, "Password cannot be blank");
    }
}

function validateConfirmedPassword(confirmedPasswordValue, passwordValue) {
    if (confirmedPasswordValue === passwordValue && confirmedPasswordValue !== "") {
        setSuccessFor(confirmedPassword);
    }
    else {
        setErrorFor(confirmedPassword, "Passwords does not match");
    }
}

function isValidUsername(usernameValue) {
    let regex = new RegExp("^[a-z0-9_-]{4,20}$");
    return regex.test(usernameValue);
}

function isValidEmail(emailValue) {
    let regex = new RegExp("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
    return regex.test(emailValue);
}

function setErrorFor(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    formControl.className = 'form-control error';
    small.innerText = message;
}

function setSuccessFor(input) {
    const formControl = input.parentElement;
    formControl.className = 'form-control success';
}