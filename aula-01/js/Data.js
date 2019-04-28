function diaValido(dia) {
  return dia > 0 && dia < 32;
}

function mesValido(mes) {
  return mes > 0 && mes < 13;
}

function anoValido(ano) {
  return ano > 1753;
}

function validaData(dia, mes, ano) {
  return diaValido(dia) && mesValido(mes) && anoValido(ano);
}

function diaDaSemanaToString(dia) {
  if (dia < 0 || dia > 6) {
    throw new RangeError("dia inválido: " + dia + ". dia deve estar entre 0 e 6.");
  }
  const nomesDiasDaSemana = ["segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira", "sábado", "domingo"];
  return nomesDiasDaSemana[dia];
}

function diaDaSemana(dia, mes, ano) {
  if (!validaData(dia, mes, ano)) {
    throw new Error("Data inválida: " + dia + "/" + mes + "/" + ano + " (dia/mes/ano)");
  }
  if (mes === 1 || mes === 2) {
    mes += 12;
    ano -= 1;
  }
  var calculoDiaDaSemanaParcial = parseInt(dia + 2 * mes + 3 * (mes + 1) / 5 + ano + ano / 4 - ano / 100 + ano / 400);
  var calculoDiaDaSemanaFinal = calculoDiaDaSemanaParcial % 7;
  return diaDaSemanaToString(calculoDiaDaSemanaFinal);
}