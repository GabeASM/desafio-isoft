<template>
    <!DOCTYPE html>
    <html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Desafio Isoft</title>
    </head>
    <body>

        <div class="contenedor">
            <div class="mb-2">
                <h2>Generar Autos</h2>
            </div>
            
            <div class="fila">
                <label for="numAutos" class="input-group-text">Cantidad </label>
                <input type="number" v-model="numAutos" class="form-control" id="numAutos" aria-describedby="emailHelp"/>
            </div>

            <div>
                <button @click="mostrarAutosGenerados()" 
                type="submit" class="btn btn-success mt-3">Generar</button>
            </div>
        </div>

    </body>
    </html>
</template>

<script>
export default {
    name: "HomePage",
    data() {
        return {
            numAutos: ""
        }
    },
    methods: {
        mostrarAutosGenerados() {

            const numAuto = this.$refs.numAutos;
            console.log(numAuto)
            this.$router.push({
                name: "autos_generados",
                params: {
                    numero: this.numAutos,
                },
            });
        },
    },
};
</script>

<style>
    .contenedor {
        display: flex;
        flex-direction: column;
        margin-bottom: 30px;
    }
    .fila {
        display: flex;
        flex-direction: row;
    }
    .input-group-text {
        width: 21%;
    }
    #autos, #filtros, #numAutos {
        width: 79%;
    }
</style>