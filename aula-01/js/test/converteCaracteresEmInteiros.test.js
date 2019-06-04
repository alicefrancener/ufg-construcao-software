const funcao = require("../funcoes/CPF.js");

let vetor = [4,3,4,1,5,2,0,0,0,8,6];

test("satisfaz", () => {
    expect(funcao.converteCaracteresEmInteiros("43415200086")).toStrictEqual(vetor);
});
