const funcao = require("../funcoes/Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.produto(10, 300)).toBe(3000);
});

test("multiplicando fora da faixa", () => {
    expect(() => {
        funcao.produto(-10, 5);
    }).toThrow(RangeError);
});

test("multiplicador fora da faixa", () => {
    expect(() => funcao.produto(100, -1)).toThrow(RangeError);
});

test("argumentos null/undefined", () => {
    expect(() => {
        funcao.produto();
    }).toThrow(TypeError);
});

test("um argumento null/undefined", () => {
    expect(() => {
        funcao.produto(10);
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.produto("abcd", 10);
    }).toThrow(TypeError);
});
