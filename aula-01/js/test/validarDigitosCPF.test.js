const funcao = require("../CPF.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f2("43415200086")).toBe(true);
});

test("nao satisfaz", () => {
    expect(funcao.f2("03085586514")).toBe(false);
});

test("cpf com menos do que 11 digitos", () => {
    expect(() => funcao.f2("0308558650")).toThrow(RangeError);
});