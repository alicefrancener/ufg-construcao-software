const funcao = require("../restoDaDivisaoInteira.js");

test("vendo se funciona", () => {
    expect(funcao(10, 3)).toBe(1);
});