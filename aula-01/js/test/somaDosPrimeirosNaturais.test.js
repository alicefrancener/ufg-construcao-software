const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.somaDosPrimeirosNaturais(10)).toBe(55);
});

test("numero fora da faixa", () => {
    expect(() => {
        funcao.somaDosPrimeirosNaturais(-1);
    }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.somaDosPrimeirosNaturais();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.somaDosPrimeirosNaturais("abcd");
    }).toThrow(TypeError);
});
