<template>
  <div>
    <h1>Autos Generados</h1>
    <div v-for="auto in autos" :key="auto.marca">{{ auto }}</div>
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
  async mounted() {
    const num = this.$route.params.numero;
    const result = await listaAutos(num);
    this.autos = result;
  },
};
</script>

<style>

</style>