/**
 * Produz Map contendo número mais sorteado e sua frequência. Se
 * houver mais de um número com a mesma frequência máxima, todos são
 * retornados.
 *
 * @returns {Map<key, value>} Map com número(s) mais sorteado(s) e sua(s)
 * frequencia(s). key = valor sorteado, value = frequência
 */
function numeroMaisSorteado() {
    const qtdAleat = 1000000;
    var mapAleatorios = new Map();

    for (let i = 0; i < qtdAleat; i++) {
        let numeroAleat = Math.floor((Math.random() * 1000));

        if (mapAleatorios.has(numeroAleat)) {
            let freq = mapAleatorios.get(numeroAleat);
            freq++;
            mapAleatorios.set(numeroAleat, freq);
        } else {
            mapAleatorios.set(numeroAleat, 1);
        }
    }

    const maxCount = getMaxFreq(mapAleatorios);

    return getMaxNumeroFreq(mapAleatorios, maxCount);
}

/**
 * Obtém a maior frequência de determinados números.
 *
 * @param {Map<key, value>} Números (key) e suas determinadas
 * frequências (value)
 * @returns {number} Frequência máxima encontrada
 */
function getMaxFreq(mapNumerosFreq) {
    let maxFreq = 0;
    for (let val of mapNumerosFreq.values()) {
        if (val > maxFreq) {
            maxFreq = val;
        }
    }

    return maxFreq;
}

/**
 * Produz Map com inteiros que contêm determinada frequência.
 *
 * @param {Map<key, value>} mapNumerosFreq Números (key) e suas determinadas
 * frequências (value)
 * @param {number} frequencia Frequência desejeda dos números a serem obtidos
 * @returns {Map<key, value>} Map com números (key) e suas determinadas
 * ocorrências (value)
 */
function getMaxNumeroFreq(mapNumerosFreq, frequencia) {
    var mapNumerosEqualsFreq = new Map();

    for (let key of mapNumerosFreq.keys()) {
        let val = mapNumerosFreq.get(key);

        if (val == frequencia) {
            mapNumerosEqualsFreq.set(key, val);
        }
    }

    return mapNumerosEqualsFreq;
}

module.exports = {numeroMaisSorteado};