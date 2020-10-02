// const {isValidUsername} = require("../src/main/webapp/resources/js/validators.js");
//
// describe("Validate username test", function() {
//     it("valid password contains only lowercase letters", function() {
//         expect(isValidUsername("username")).toBe(true);
//     });
//
//     it("password too short", function() {
//         expect(isValidUsername("a")).toBe(false);
//     });
//
//     it("password too long", function() {
//         expect(isValidUsername("tooLongPasswordContainsMoreThenTwentyLetters")).toBe(false);
//     });
//
//     it("incorrect symbols", function() {
//         expect(isValidUsername("a?bc,af.s!f")).toBe(false);
//     });
//
//     it("valid password with letters, symbols and digits", function() {
//         expect(isValidUsername("correct-password_1234")).toBe(true);
//     });
// })