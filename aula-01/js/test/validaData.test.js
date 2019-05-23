const funcao = require("../Data.js");

test("data invalida", () => {
    expect(() => {
        funcao.diaValido(10,-2,1999);
    }).toThrow();
});