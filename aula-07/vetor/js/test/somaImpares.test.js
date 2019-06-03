const funcao = require("../funcoes/somaImpares.js");


test("numero null/undefined", () => {
    expect(() => {
        funcao.somaImpares();
    }).toThrow(TypeError);
});

test("numero não é inteiro", () => {
    expect(() => {
        funcao.somaImpares([10.2, "a", 0]);
    }).toThrow(TypeError);
});

test("satisfaz (caso classico)", () => {
    expect(funcao.somaImpares([1, 8, 7, 3, 11])).toBe(22);
});