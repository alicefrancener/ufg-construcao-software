const funcao = require("../funcoes/Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.razaoAurea(1, 2, 1)).toBe(1.5);
});

test("numeroA fora da faixa", () => {
    expect(() => {
        funcao.razaoAurea(-1, 10, 10);
    }).toThrow(RangeError);
});

test("numeroB fora da faixa", () => {
    expect(() => {
        funcao.razaoAurea(11, 10, 10);
    }).toThrow(RangeError);
});

test("precisao fora da faixa", () => {
    expect(() => {
        funcao.razaoAurea(10, 8, 0);
    }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.razaoAurea();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.razaoAurea("abcd", 10, "bde");
    }).toThrow(TypeError);
});