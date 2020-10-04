// const validators = require('validators.js');

const form = document.getElementById('form');
const username = document.getElementById('username');
const email = document.getElementById('email');
const password = document.getElementById('password');
const confirmedPassword = document.getElementById('confirmedPassword');

form.addEventListener('submit', (e) => {
    e.preventDefault();
    if (validateInputFields()) {
        form.submit();
    }
});

username.addEventListener('input', (_) => {
    validateUsername();
});

function validateInputFields() {
    const isUsernameValid = validateUsername();
    // const isUsernameValid = validateField(username, usernameValidator, 'Invalid username');
    // const isEmailValid = validateField(email, emailValidator, 'Invalid email');
    // const isPasswordValid = validateField(password, passwordValidator, 'Password cannot be blank');
    // const isConfirmedPasswordValid = validateConfirmedPassword(confirmedPassword, password, confirmedPasswordValidator, 'Passwords does not match');
    return isUsernameValid;
}

// function validateField(field, validator, errorMessage) {
//     const value = field.value.trim();
//     if (validator(value) === true) {
//         setSuccessFor(field);
//         return true;
//     }
//     else {
//         setErrorFor(field, errorMessage);
//         return false;
//     }
// }

function validateUsername() {
    const usernameValue = username.value.trim();
    if (usernameValidator(usernameValue)) {
        setSuccessFor(username);
        return true;
    }
    else {
        setErrorFor(username, "Invalid username");
        return false;
    }
}

// function validateConfirmedPassword(confirmedPasswordField, passwordField, validator, errorMessage) {
//     const confirmedPasswordValue = confirmedPasswordField.value.trim();
//     const passwordValue = passwordField.value.trim();
//     if (validator(confirmedPasswordValue, passwordValue) === true) {
//         setSuccessFor(confirmedPasswordField);
//         return true;
//     }
//     else {
//         setErrorFor(confirmedPasswordField, errorMessage);
//         return false;
//     }
// }

function confirmedPasswordValidator(confirmedPasswordValue, passwordValue) {
    return confirmedPasswordValue === passwordValue && confirmedPasswordValue !== '';
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

function usernameValidator(usernameValue) {
    let regex = new RegExp("^[a-z0-9_-]{4,20}$");
    return regex.test(usernameValue);
}

function emailValidator(emailValue) {
    let regex = new RegExp("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
    return regex.test(emailValue);
}

function passwordValidator(passwordValue) {
    return passwordValue !== '';
}
