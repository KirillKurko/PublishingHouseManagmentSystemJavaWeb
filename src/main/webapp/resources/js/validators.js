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

module.exports = {usernameValidator, emailValidator, passwordValidator};