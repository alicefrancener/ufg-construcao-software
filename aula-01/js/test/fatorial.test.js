const funcao = require("../funcoes/Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.fatorial(5)).toBe(120);
});

test("numero fora da faixa", () => {
    expect(() => funcao.fatorial(-1)).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.fatorial();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.fatorial("abcd");
    }).toThrow(TypeError);
});