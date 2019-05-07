const funcao = require("../Data.js");

test("data invalida", () => {
    expect(() => {
        funcao.f4(10,-2,1999);
    }).toThrow();
});