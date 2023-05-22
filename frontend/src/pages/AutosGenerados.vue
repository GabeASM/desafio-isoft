<template>
  <div>
    <h1>Autos Generados</h1>

    <label for="numAutos" class="input-group-text">Filtro de precio </label>
    <input type="number" v-model="precioFiltro" class="form-control" id="numAutos" aria-describedby="emailHelp" />

    <div>
      <button @click="filtro()" type="submit" class="btn btn-success mt-3">Aplicar filtro</button>
      <button @click="borrarFiltro()" type="submit" class="btn btn-danger mt-3">Borrar filtro</button>

    </div>

    <div>
      <table  class="table table-striped">
      <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Marca</th>
            <th scope="col">Año</th>
            <th scope="col">Color</th>
            <th scope="col">Tipo</th>
            <th scope="col">Precio</th>
            <th scope="col">Detalle</th>
          </tr>
        </thead>
        <tbody v-if="condicionFiltro === false">
          <tr  v-for="(auto) in autos" :key="auto.id">
            <th scope="row">{{ auto.id }}</th>
            <td>{{ auto.marca }}</td>
            <td>{{ auto.anio }}</td>
            <td>{{ auto.color }}</td>
            <td>{{ auto.tipoAuto }}</td>
            <td>${{ auto.precio }}</td>
            <td>
              <button @click="verDetalle(auto)" type="submit" class="btn btn-primary rounded-pill">Ver</button>
            </td>
          </tr>
        </tbody>
          <tbody v-else>
          <tr  v-for="(auto) in autosFiltrados" :key="auto.id" >
            <th scope="row">{{ auto.id }}</th>
            <td>{{ auto.marca }}</td>
            <td>{{ auto.anio }}</td>
            <td>{{ auto.color }}</td>
            <td>{{ auto.tipoAuto }}</td>
            <td>${{ auto.precio }}</td>
            <td>
              <button @click="verDetalle(auto)" type="submit" class="btn btn-primary rounded-pill">Ver</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import { filtrarAutos, listaAutos } from '../services/generar_autos.services';

export default {
  name: "AutosGeneradosPage",
  data() {
    return {
      autos: [],
      autosFiltrados: [],
      precioFiltro: 0,
      condicionFiltro: false,
      mensajeListaVacia: false,
    };
  },
  props: {
    objAuto: {
      type: Object,
      default: null,
    },
  },
  mounted() {
    this.obtenerAutos();
    this.obtenerFiltro();
    
  },
  methods: {
    async obtenerAutos() {
      const num = this.$route.params.numero;
      
      if (history.state && history.state.autosGenerados && history.state.autosGenerados.numero === num) {
        // Los datos están almacenados en el historial del navegador, no es necesario volver a cargar el backend
        this.autos = history.state.autosGenerados.data;
      } else {
        localStorage.clear()
        // Cargar el backend normalmente
        const result = await listaAutos(num);
        this.autos = result;

        // Almacenar los datos en el historial del navegador
        const state = { autosGenerados: { numero: num, data: result } };
        history.replaceState(state, '');
      }
    },
    obtenerFiltro() {
      const filtroGuardado = localStorage.getItem('filtroAutos');

      if (filtroGuardado) {
        const filtro = JSON.parse(filtroGuardado);
        this.precioFiltro = filtro.precioFiltro;
        this.condicionFiltro = filtro.condicionFiltro;
        this.filtro();
      }
    },
    guardarFiltro() {
      const filtro = {
        precioFiltro: this.precioFiltro,
        condicionFiltro: this.condicionFiltro,
      };
      localStorage.setItem('filtroAutos', JSON.stringify(filtro));
      
    },
    async borrarFiltro() {
      this.condicionFiltro = false;
      this.autosFiltrados = this.autos;
      
      this.precioFiltro = 1
      const resultadoFiltrado = await filtrarAutos(this.precioFiltro);
      this.autosFiltrados = resultadoFiltrado;
      this.guardarFiltro();
    },
    async filtro() {
      if (this.precioFiltro > 0) {
        this.condicionFiltro = true;
        const resultadoFiltrado = await filtrarAutos(this.precioFiltro);
        this.autosFiltrados = resultadoFiltrado;
        
        this.guardarFiltro();
      }
    },
    verDetalle(objAuto) {
      this.$router.push({
        name: "detalle",
        params: {
          id: objAuto.id,
        },
        props: {
          autos: this.condicionFiltro ? this.autosFiltrados : this.autos,
        },
      });
    },
  },
};

</script>

<style></style>