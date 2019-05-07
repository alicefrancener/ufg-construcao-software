const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f3(10, 300)).toBe(3000);
});

test("multiplicando fora da faixa", () => {
    expect(() => {
        funcao.f3(-10, 5);
    }).toThrow(RangeError);
});

test("multiplicador fora da faixa", () => {
    expect(() => funcao.f3(100, -1)).toThrow(RangeError);
});

test("argumentos null/undefined", () => {
    expect(() => {
        funcao.f3();
    }).toThrow(TypeError);
});

test("um argumento null/undefined", () => {
    expect(() => {
        funcao.f3(10);
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.f3("abcd", 10);
    }).toThrow(TypeError);
});