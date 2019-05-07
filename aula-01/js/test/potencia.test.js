const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f4(10, 2)).toBe(100);
});

test("base fora da faixa", () => {
    expect(() => {
        funcao.f4(-10, 5);
    }).toThrow(RangeError);
});

test("expoente fora da faixa", () => {
    expect(() => funcao.f4(3, -1)).toThrow(RangeError);
});