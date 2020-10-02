window.load = function() {}

const form = document.getElementById("form");
const username = document.getElementById("username");
const email = document.getElementById("email");
const password = document.getElementById("password");
const confirmedPassword = document.getElementById("confirmedPassword");

form.addEventListener("submit", (e) => {
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
    validatePassword();
}

function validateUsername(usernameValue) {
    if (isValidUsername(usernameValue)) {
        setSuccessFor(username);
    }
    else {
        setErrorFor(username, "Username cannot be blank");
    }
}

function isValidUsername(usernameValue) {
    return "^[a-z0-9_-]{4,20}$".test(usernameValue);
}


module.exports = {isValidUsername};