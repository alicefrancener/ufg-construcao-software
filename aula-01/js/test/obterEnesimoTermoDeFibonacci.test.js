const funcao = require("../funcoes/Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.obterEnesimoTermoDeFibonacci(6)).toBe(8);
});

test("argumento fora da faixa", () => {
    expect(() => {
        funcao.obterEnesimoTermoDeFibonacci(-1);
    }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.obterEnesimoTermoDeFibonacci();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.obterEnesimoTermoDeFibonacci("abcd");
    }).toThrow(TypeError);
});