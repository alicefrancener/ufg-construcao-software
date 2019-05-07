const funcao = require("../Data.js");

test("mes fora da faixa", () => {
    expect(() => {
        funcao.f1(32);
    }).toThrow();
});