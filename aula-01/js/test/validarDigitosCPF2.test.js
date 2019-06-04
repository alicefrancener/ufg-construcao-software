const funcao = require("../funcoes/CPF.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.validarDigitosCPF2("43415200086")).toBe(true);
});

test("nao satisfaz", () => {
    expect(funcao.validarDigitosCPF2("03085586514")).toBe(false);
});

test("cpf com menos do que 11 digitos", () => {
    expect(() =>
        funcao.validarDigitosCPF2("0308558650")).toThrow(RangeError);
});

test("cpf com mais do que 11 digitos", () => {
    expect(() =>
        funcao.validarDigitosCPF2("030855865001")).toThrow(RangeError);
});

test("argumento null/undefined ", () => {
    expect(() =>
        funcao.validarDigitosCPF2()).toThrow(TypeError);
});