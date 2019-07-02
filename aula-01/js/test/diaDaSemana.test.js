const funcao = require("../funcoes/Data.js");

test("mes invalido", () => {
    expect(() => {
        funcao.diaDaSemana(1,13,2019);
    }).toThrow();
});

test("dia invalido", () => {
    expect(() => {
        funcao.diaDaSemana(32,11,2019);
    }).toThrow();
});