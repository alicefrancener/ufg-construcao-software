function validarData(dia, mes, ano){
  if(dia >= 1 && dia <= 31){
    if(mes >= 1 && mes <= 12){
      if(ano > 1753){
        return true;
      }
    }
  }
  return false;
}

function numeroEmDia(numero){
  var semana = "";
  switch (numero) {
    case 0:
      semana = "segunda-feira";
      break;
    case 1:
      semana = "terça-feira";
      break;
    case 2:
      semana = "quarta-feira";
      break;
    case 3:
      semana = "quinta-feira";
      break;
    case 4:
      semana = "sexta-feira";
      break;
    case 5:
      semana = "sábado";
      break;
    case 6:
      semana = "domingo";
    }
    return semana;
}

function diaDaSemana(dia, mes, ano){
  if(validarData(dia, mes, ano)){
    if (mes === 1 || mes === 2) {
      mes += 12;
      ano -=  1;
    }
    var soma = parseInt(dia + 2 * mes + 3 * (mes + 1) / 5 + ano + ano / 4 - ano / 100 + ano / 400);
    var resultado = soma % 7;
    return numeroEmDia(resultado);
  }
  throw new Error("Data inválida: Argumento inválido: 1 <= dia <= 31, 1 <= mes <= 12, ano > 1753");
}