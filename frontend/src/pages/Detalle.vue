<template>
    <div>
        <h1>Detalle</h1>
        <div>
            <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">Marca</th>
                <th scope="col">Año</th>
                <th scope="col">Color</th>
                <th scope="col">Turbo</th>
                <th scope="col">Tipo</th>
                <th scope="col">Motor</th>
                <th scope="col">Popularidad</th>
                <th scope="col">Cantidad en cabina</th>
                <th scope="col">SunRoof</th>
                <th scope="col">Precio</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{{ auto.marca }}</td>
                <td>{{ auto.anio }}</td>
                <td>{{ auto.color }}</td>
                <td>{{ auto.turbo }}</td>
                <td>{{ auto.tipoAuto }}</td>
                <td>{{ auto.motor }}</td>
                <td>{{ auto.popularidad }}</td>
                <td>{{ auto.cantidadCabina }}</td>
                <td>{{ auto.sunRoof }}</td>
                <td>${{ auto.precio }}</td>
              </tr>
            </tbody>
          </table>
        </div>
    </div>
</template>

<script>
import { verDetalle } from '@/services/generar_autos.services';
export default {
    name: "DetallePage",
  data() {
    return {
      auto: Object,
    };
  },
  async mounted() {
    const num = this.$route.params.id;
    const result = await verDetalle(num);
    this.auto = result;
  },
};
</script>

<style></style>