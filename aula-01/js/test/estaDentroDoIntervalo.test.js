const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.estaDentroDoIntervalo(10, -100, 100)).toBe(true);
});

test("nao satisfaz (caso classico)", () => {
    expect(funcao.estaDentroDoIntervalo(-101, -100, 100)).toBe(false);
});
