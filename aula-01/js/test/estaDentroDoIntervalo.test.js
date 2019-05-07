const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f5(10, -100, 100)).toBe(true);
});

test("nao satisfaz (caso classico)", () => {
    expect(funcao.f5(-101, -100, 100)).toBe(false);
});