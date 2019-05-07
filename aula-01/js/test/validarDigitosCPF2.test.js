const funcao = require("../CPF.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f3("43415200086")).toBe(true);
});

test("nao satisfaz", () => {
    expect(funcao.f3("03085586514")).toBe(false);
});

test("cpf com menos do que 11 digitos", () => {
    expect(() => funcao.f3("0308558650")).toThrow(RangeError);
});

test("cpf com mais do que 11 digitos", () => {
    expect(() => funcao.f3("030855865001")).toThrow(RangeError);
});

test("argumento null/undefined ", () => {
    expect(() => funcao.f3()).toThrow(TypeError);
});