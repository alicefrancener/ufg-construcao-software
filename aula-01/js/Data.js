class DataInvalidaError extends Error {
  constructor(msg) {
    super(msg);
    this.name = "DataInvalidaError";
  }
}

function diaValido(dia) {
  if (dia < 1 || dia > 31){
    throw new DataInvalidaError("dia invalido: " + dia);
  }
}

function mesValido(mes) {
  if (mes < 1 || mes > 12) {
    throw new DataInvalidaError("mes invalido: " + mes);
  }
}

function anoValido(ano) {
  if (ano <= 1753) {
    throw new DataInvalidaError("ano invalido: " + ano);
  }
}

function validaData(dia, mes, ano) {
  diaValido(dia);
  mesValido(mes);
  anoValido(ano);
}

function diaDaSemanaToString(dia) {
  const nomesDiasDaSemana = ["segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira", "sábado", "domingo"];
  return nomesDiasDaSemana[dia];
}

function diaDaSemana(dia, mes, ano) {
  validaData(dia, mes, ano);
  if (mes === 1 || mes === 2) {
    mes += 12;
    ano -= 1;
  }
  var calculoDiaDaSemanaParcial = parseInt(dia + 2 * mes + 3 * (mes + 1) / 5 + ano + ano / 4 - ano / 100 + ano / 400);
  var calculoDiaDaSemanaFinal = calculoDiaDaSemanaParcial % 7;
  return diaDaSemanaToString(calculoDiaDaSemanaFinal);
}