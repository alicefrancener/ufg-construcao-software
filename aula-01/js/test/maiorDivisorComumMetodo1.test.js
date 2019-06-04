const funcao = require("../funcoes/Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.maiorDivisorComumMetodo1(10, 5)).toBe(5);
});

test("numeroB fora da faixa", () => {
    expect(() => {
        funcao.maiorDivisorComumMetodo1(10, 100);
    }).toThrow(RangeError);
});

test("numeroB fora da faixa", () => {
    expect(() => {
        funcao.maiorDivisorComumMetodo1(10, -1);
    }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.maiorDivisorComumMetodo1();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.maiorDivisorComumMetodo1("abcd", "cc");
    }).toThrow(TypeError);
});