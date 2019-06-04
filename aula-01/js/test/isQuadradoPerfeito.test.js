const funcao = require("../funcoes/Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.isQuadradoPerfeito(9)).toBe(true);
});

test("nao satisfaz ", () => {
    expect(funcao.isQuadradoPerfeito(7)).toBe(false);
});

test("valor fora da faixa", () => {
    expect(() => {
        funcao.isQuadradoPerfeito(0);
    }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.isQuadradoPerfeito();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.isQuadradoPerfeito("abcd");
    }).toThrow(TypeError);
});