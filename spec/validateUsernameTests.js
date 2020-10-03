const validators = require("../src/main/webapp/resources/js/validators.js");

const usernameValidator = validators.usernameValidator;

describe("Validate username test", function() {
    it("valid password contains only lowercase letters", function() {
        expect(usernameValidator("username")).toBe(true);
    });

    it("password too short", function() {
        expect(usernameValidator("a")).toBe(false);
    });

    it("password too long", function() {
        expect(usernameValidator("tooLongPasswordContainsMoreThenTwentyLetters")).toBe(false);
    });

    it("incorrect symbols", function() {
        expect(usernameValidator("a?bc,af.s!f")).toBe(false);
    });

    it("valid password with letters, symbols and digits", function() {
        expect(usernameValidator("correct-password_1234")).toBe(true);
    });
})