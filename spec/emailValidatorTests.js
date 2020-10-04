const validators = require("../src/main/webapp/resources/js/validators.js");

const emailValidator = validators.emailValidator;

describe("email validator tests", function() {
    it("valid email", function() {
        expect(emailValidator("username@gmail.com")).toBe(true);
    });

    it("invalid email without @", function() {
        expect(emailValidator("usernamegmail.com")).toBe(false);
    });

    it("invalid email without .", function() {
        expect(emailValidator("username@gmail")).toBe(false);
    });

    it("invalid email without letters after dot", function() {
        expect(emailValidator("username@gmail.")).toBe(false);
    });

    it("invalid email with @ first", function() {
        expect(emailValidator("@gmail.com")).toBe(true);
    });
})