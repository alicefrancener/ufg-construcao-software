const funcao = require("../funcoes/Matematica.js");

test("3025 satisfaz (caso classico)", () => {
    expect(funcao.possuiPropriedade3025(3025)).toBe(true);
});

test("3024 nao satisfaz", () => {
    expect(funcao.possuiPropriedade3025(3024)).toBe(false);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.possuiPropriedade3025();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.possuiPropriedade3025("abcd");
    }).toThrow(TypeError);
});

test("valor negativo fora da faixa", () => {
    expect(() => {
        funcao.possuiPropriedade3025(-1);
    }).toThrow(RangeError);
});

test("valor com mais de 4 digitos fora da faixa", () => {
    expect(() => funcao.possuiPropriedade3025(10000)).toThrow(RangeError);
});
