import axios from 'axios';

const BASE_URL = 'http://localhost:3001';

function listaAutos(numero) {
  return axios
    .get(`${BASE_URL}/generarAutos/${numero}`)
    .then((result) => {
      return result.data;
    });
}

function verDetalle(id) {
  return axios
    .get(`${BASE_URL}/detalle/${id}`)
    .then((result) => {
      return result.data;
    });
}
function filtrarAutos(precio){
  return axios
  .get(`${BASE_URL}/filtro/${precio}`)
  .then((result) => {
    return result.data
  })
}


export { listaAutos, verDetalle , filtrarAutos };
