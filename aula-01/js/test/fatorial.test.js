const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f8(5)).toBe(120);
});

test("numero fora da faixa", () => {
    expect(() => funcao.f8(-1)).toThrow(RangeError);
});