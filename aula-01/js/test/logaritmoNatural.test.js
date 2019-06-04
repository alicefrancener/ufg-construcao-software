const funcao = require("../funcoes/Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.logaritmoNatural(1, 3)).toBe(2.5);
});

test("expoente fora da faixa", () => {
    expect(() => {
        funcao.logaritmoNatural(-1, 10);
    }).toThrow(RangeError);
});

test("precisao fora da faixa", () => {
    expect(() => {
        funcao.logaritmoNatural(5, 1);
    }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.logaritmoNatural();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.logaritmoNatural("abcd", 10);
    }).toThrow(TypeError);
});