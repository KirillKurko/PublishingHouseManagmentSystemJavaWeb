function isValidUsername(usernameValue) {
    return "^[a-z0-9_-]{4,20}$".test(usernameValue);
}

module.exports = {isValidUsername};