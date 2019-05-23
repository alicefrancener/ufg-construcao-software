const funcao = require("../CPF.js");

test("satisfaz", () => {
    expect(funcao.converteCaracteresEmInteiros("43415200086")).toBe({
        4,
        3,
        4,
        1,
        5,
        2,
        0,
        0,
        0,
        8,
        6
    });
});