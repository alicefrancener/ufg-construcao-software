const funcao = require("../funcoes/Data.js");

test("ano fora da faixa", () => {
    expect(() => {
        funcao.anoValido(350);
    }).toThrow();
});

test("ano null/undefined", () => {
    expect(() => {
        funcao.anoValido();
    }).toThrow();
});

test("ano nao numerico", () => {
    expect(() => {
        funcao.anoValido("abcd");
    }).toThrow();
});

test("ano nao inteiro", () => {
    expect(() => {
        funcao.anoValido(10.5);
    }).toThrow();
});