const funcao = require("../Data.js");

test("mes fora da faixa", () => {
    expect(() => {
        funcao.f2(13);
    }).toThrow();
});