<template>
  <div>
    <h1>Autos Generados</h1>
    <div>
      <table class="table table-striped">
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
        <tbody>
          <tr v-for="(auto, index) in autos" :key="auto.id">
            <th scope="row">{{ index + 1 }}</th>
            <td>{{ auto.marca }}</td>
            <td>{{ auto.anio }}</td>
            <td>{{ auto.color }}</td>
            <td>{{ auto.tipoAuto }}</td>
            <td>${{ auto.precio }}</td>
            <td>
              <button @click="verDetalle(auto)"
               type="submit" class="btn btn-primary rounded-pill">Ver</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import { listaAutos } from '../services/generar_autos.services';
export default {
  name: "AutosGeneradosPage",
  data() {
    return {
      autos: [],
    };
  },
  props: {
    objAuto: {
      type: Object,
      default: null,
    },
  },
  async mounted() {
    const num = this.$route.params.numero;
    const result = await listaAutos(num);
    this.autos = result;
  },
  methods: {
    verDetalle(objAuto) {
      this.$router.push({
        name: "detalle",
        params: {
          id: objAuto.id,
        },
        props: {
          autos: this.autos,
        },
      });
    },
  },
};
</script>

<style></style>