const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.restoDaDivisaoInteira(10, 3)).toBe(1);
});

test("numerador fora da faixa", () => {
    expect(() => {
        funcao.restoDaDivisaoInteira(0, 5);
    }).toThrow(RangeError);
});

test("denominador fora da faixa", () => {
    expect(() => funcao.restoDaDivisaoInteira(100, -1)).toThrow(RangeError);
});

test("ambos argumentos null/undefined", () => {
    expect(() => {
        funcao.restoDaDivisaoInteira();
    }).toThrow(TypeError);
});

test("um argumento null/undefined", () => {
    expect(() => {
        funcao.restoDaDivisaoInteira(10);
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.restoDaDivisaoInteira("abcd", 10);
    }).toThrow(TypeError);
});
