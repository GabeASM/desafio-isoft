import axios from 'axios';

const BASE_URL = 'http://localhost:3001';

function listaAutos(numero) {
  return axios
    .get(`${BASE_URL}/generarAutos/${numero}`)
    .then((result) => {
      return result.data;
    });
}

export { listaAutos };
