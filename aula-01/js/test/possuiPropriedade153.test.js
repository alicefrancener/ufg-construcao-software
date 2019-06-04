const funcao = require("../funcoes/Matematica.js");

test("153 satisfaz (caso classico)", () => {
    expect(funcao.possuiPropriedade153(153)).toBe(true);
});

test("157 nao satisfaz", () => {
    expect(funcao.possuiPropriedade153(157)).toBe(false);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.possuiPropriedade153();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.possuiPropriedade153("abcd");
    }).toThrow(TypeError);
});

test("valor negativo fora da faixa", () => {
    expect(() => {
        funcao.possuiPropriedade153(-1);
    }).toThrow(RangeError);
});

test("valor de 4 digitos fora da faixa", () => {
    expect(() => funcao.possuiPropriedade153(1000)).toThrow(RangeError);
});
