const funcao = require("../funcoes/Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.raizQuadrada(4, 10)).toBe(2);
});

test("valor fora da faixa", () => {
    expect(() => {
        funcao.raizQuadrada(0, 10);
    }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.raizQuadrada();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.raizQuadrada("abcd", "cc");
    }).toThrow(TypeError);
});