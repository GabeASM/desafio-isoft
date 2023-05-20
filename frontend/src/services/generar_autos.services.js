import axios from 'axios';

const BASE_URL = 'http://localhost:3001';

function listaAutos(numero) {
  return axios
    .get(`${BASE_URL}/${numero}`)
    .then((result) => {
      return result.data;
    });
}

/*function getDetails(id) {
  return axios
    .get(`${BASE_URL}/pokemon/${id}`)
    .then((result) => {
      return result.data;
    });
}*/

export { listaAutos };
