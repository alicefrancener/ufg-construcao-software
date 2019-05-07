const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f7(10)).toBe(55);
});

test("numero fora da faixa", () => {
    expect(() => {
        funcao.f7(-1);
    }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.f7();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.f7("abcd");
    }).toThrow(TypeError);
});