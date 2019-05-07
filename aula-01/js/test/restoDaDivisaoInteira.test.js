const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f2(10, 3)).toBe(1);
});

test("numerador fora da faixa", () => {
    expect(() => {
        funcao.f2(0, 5);
    }).toThrow(RangeError);
});

test("denominador fora da faixa", () => {
    expect(() => funcao.f2(100, -1)).toThrow(RangeError);
});

test("ambos argumentos null/undefined", () => {
    expect(() => {
        funcao.f2();
    }).toThrow(TypeError);
});

test("um argumento null/undefined", () => {
    expect(() => {
        funcao.f2(10);
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.f2("abcd", 10);
    }).toThrow(TypeError);
});