const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f18(3, [10, 5, 6])).toBe(79);
});