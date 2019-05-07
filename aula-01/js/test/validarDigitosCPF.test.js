const funcao = require("../CPF.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f2("43415200086")).toBe(true);
});

test("nao satisfaz", () => {
    expect(funcao.f2("43415200016")).toBe(false);
});

test("cpf com menos do que 11 digitos", () => {
    expect(() => funcao.f2("0308558650")).toThrow(RangeError);
});

test("cpf com mais do que 11 digitos", () => {
    expect(() => funcao.f2("030855865001")).toThrow(RangeError);
});

test("argumento null/undefined ", () => {
    expect(() => funcao.f2()).toThrow(TypeError);
});