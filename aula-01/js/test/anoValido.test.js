const funcao = require("../Data.js");

test("ano fora da faixa", () => {
    expect(() => {
        funcao.f1(350);
    }).toThrow();
});