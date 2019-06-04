const funcao = require("../funcoes/Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.potencia(10, 2)).toBe(100);
});

test("base fora da faixa", () => {
    expect(() => {
        funcao.potencia(-10, 5);
    }).toThrow(RangeError);
});

test("expoente fora da faixa", () => {
    expect(() => funcao.potencia(3, -1)).toThrow(RangeError);
});

test("argumentos null/undefined", () => {
    expect(() => {
        funcao.potencia();
    }).toThrow(TypeError);
});

test("um argumento null/undefined", () => {
    expect(() => {
        funcao.potencia(10);
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.potencia("abcd", 10);
    }).toThrow(TypeError);
});