const funcao = require("../funcoes/conteIguais.js");

test("argumento null/undefined", () => {
    expect(() => {
        funcao.conteIguais();
    }).toThrow(TypeError);
});

test("argumento não é numérico", () => {
    expect(() => {
        funcao.conteIguais([10, "a", 0], 0);
    }).toThrow(TypeError);
});

test("satisfaz (caso classico)", () => {
    expect(funcao.conteIguais([1, 1, 7, 3, 11, 1], 1)).toBe(3);
});