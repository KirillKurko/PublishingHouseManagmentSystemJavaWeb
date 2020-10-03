const validators = require('validators.js')

const form = document.getElementById("form");
const username = document.getElementById("username");
const email = document.getElementById("email");
const password = document.getElementById("password");
const confirmedPassword = document.getElementById("confirmedPassword");

form.addEventListener('submit', (e) => {
    e.preventDefault();
    if (validateInputFields() === true) {
        form.submit();
    }
});

function validateInputFields() {
    const isUsernameValid = validateField(username, validators.usernameValidator, 'Invalid username');
    const isEmailValid = validateField(email, validators.emailValidator, 'Invalid email');
    const isPasswordValid = validateField(password, validators.passwordValidator, 'Password cannot be blank');
    const isConfirmedPasswordValid = validateField(confirmedPassword, confirmedPasswordValidator, 'Passwords does not match');
    return isUsernameValid && isEmailValid && isPasswordValid && isConfirmedPasswordValid;
}

function validateField(field, validator, errorMessage) {
    const value = field.value.trim();
    if (validator(value)) {
        setSuccessFor(field);
        return true;
    }
    else {
        setErrorFor(field, errorMessage);
        return false;
    }
}

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