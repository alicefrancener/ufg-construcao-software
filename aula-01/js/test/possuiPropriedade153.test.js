const funcao = require("../Matematica.js");

test("153 satisfaz (caso classico)", () => {
    expect(funcao.f6(153)).toBe(true);
});

test("157 nao satisfaz", () => {
    expect(funcao.f6(157)).toBe(false);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.f6();
    }).toThrow();
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.f6("abcd");
    }).toThrow();
});

test("valor negativo fora da faixa", () => {
    expect(() => {
        funcao.f6(-1);
    }).toThrow(RangeError);
});

test("valor de 4 digitos fora da faixa", () => {
    expect(() => funcao.f6(1000)).toThrow(RangeError);
});