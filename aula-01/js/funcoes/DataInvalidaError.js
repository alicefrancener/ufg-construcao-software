/**
 * Erro para uma data inválida
 */
class DataInvalidaError extends Error {
  constructor(msg) {
      super(msg);
      this.name = "DataInvalidaError";
  }
}

export default DataInvalidaError;