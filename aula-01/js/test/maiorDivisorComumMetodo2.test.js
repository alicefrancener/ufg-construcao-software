const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f16(10, 5)).toBe(5);
});

test("numeroB fora da faixa", () => {
    expect(() => {
        funcao.f16(10, 100);
    }).toThrow(RangeError);
});

test("numeroB fora da faixa", () => {
    expect(() => {
        funcao.f16(10, -1);
    }).toThrow(RangeError);
});