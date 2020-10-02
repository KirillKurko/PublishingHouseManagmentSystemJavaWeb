const {isValidUsername} = require("../src/main/webapp/resources/js/registrationPageValidation.js");

describe("Validate username test", function() {
    it("valid password contains only lowercase letters", function() {
        expect(isValidUsername("username")).toBe(true);
    });
})