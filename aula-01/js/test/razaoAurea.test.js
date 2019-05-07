const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f11(1, 2, 1)).toBe(1.5);
});

test("numeroA fora da faixa", () => {
    expect(() => {
        funcao.f11(-1, 10, 10);
    }).toThrow(RangeError);
});

test("numeroB fora da faixa", () => {
    expect(() => {
        funcao.f11(11, 10, 10);
    }).toThrow(RangeError);
});

test("precisao fora da faixa", () => {
    expect(() => {
        funcao.f11(10, 8, 0);
    }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.f11();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.f11("abcd", 10, "bde");
    }).toThrow(TypeError);
});