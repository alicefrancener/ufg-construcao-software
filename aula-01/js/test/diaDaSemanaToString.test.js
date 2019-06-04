const funcao = require("../funcoes/Data.js");

test("satisfaz", () => {
    expect(funcao.diaDaSemanaToString(2)).toBe("quarta-feira");
});