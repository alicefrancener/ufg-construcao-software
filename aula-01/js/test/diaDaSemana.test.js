const funcao = require("../Data.js");

test("satisfaz", () => {
    expect(funcao.diaDaSemana(7, 5, 2019)).toBe("terça-feira");
});