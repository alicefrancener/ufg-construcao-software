import javax.swing.text.TableView.TableRow;

public class Data {

  private int dia;
  private int mes;
  private int ano;

  public Data(int dia, int mes, int ano) {
    setDia(dia);
    setMes(mes);
    setAno(ano);
  }

  public void setDia(int dia) {
    if (dia < 1 || dia > 31) {
      throw new IllegalArgumentException("dia invalido: " + dia);
    }
    this.dia = dia;
  }

  public void setMes(int mes) {
    if (mes < 1 || mes > 12) {
      throw new IllegalArgumentException("mes inválido: " + mes);
    }
    this.mes = mes;
  }

  public void setAno(int ano) {
    if (ano < 1754) {
      throw new IllegalArgumentException("ano inválido: " + ano);
    }
    this.ano = ano;
  }

  public int getDia() {
    return this.dia;
  }

  public int getMes() {
    return this.mes;
  }

  public int getAno() {
    return this.ano;
  }

  public String diaDaSemanaToString(int dia) {
    if(dia < 0 || dia > 6){
      throw new IllegalArgumentException("Dia inválido: " + dia + ". Dia deve estar entre 0 e 6.");
    }
    String nomes[] = {"segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira", "sábado", "domingo"};
    return nomes[dia];
  }

  public String diaDaSemana() {
    int mes = getMes();
    int ano = getAno();
    if (getMes() == 1 | getMes() == 2) {
      mes = getMes() + 12;
      ano = getAno() - 1;
    }
    int soma = getDia() + 2 * mes + 3 * (mes + 1) / 5 + ano + ano / 4 - ano / 100 + ano / 400;
    int resultado = soma % 7;
    return diaDaSemanaToString(resultado);
  }

}
