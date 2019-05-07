const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f13(4, 10)).toBe(2);
});

test("valor fora da faixa", () => {
    expect(() => {
        funcao.f13(0, 10);
    }).toThrow(RangeError);
});