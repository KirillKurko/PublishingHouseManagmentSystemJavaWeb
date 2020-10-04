const validators = require("../src/main/webapp/resources/js/validators.js");

const passwordValidator = validators.passwordValidator;

describe("password validator tests", function() {
    it("valid password", function() {
        expect(passwordValidator("correctPasswordWithLettersDigits123andSymbols_-")).toBe(true);
    });

    it("invalid empty password", function() {
        expect(passwordValidator("")).toBe(false);
    });
})