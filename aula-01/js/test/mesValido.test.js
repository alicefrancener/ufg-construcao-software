const funcao = require("../funcoes/Data.js");

test("mes fora da faixa", () => {
    expect(() => {
        funcao.mesValido(13);
    }).toThrow();
});

test("mes null/undefined", () => {
    expect(() => {
        funcao.mesValido();
    }).toThrow();
});

test("mes nao numerico", () => {
    expect(() => {
        funcao.mesValido("abcd");
    }).toThrow();
});

test("mes nao inteiro", () => {
    expect(() => {
        funcao.mesValido(10.5);
    }).toThrow();
});