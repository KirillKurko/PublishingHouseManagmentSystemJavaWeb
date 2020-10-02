function isValidUsername(usernameValue) {
    let regex = new RegExp("^[a-z0-9_-]{4,20}$");
    return regex.test(usernameValue);
}

module.exports = {isValidUsername};