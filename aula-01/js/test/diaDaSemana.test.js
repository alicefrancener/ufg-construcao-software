const funcao = require("../Data.js");

test("satisfaz", () => {
    expect(funcao.f6(7, 5, 2019)).toBe("terça-feira");
});