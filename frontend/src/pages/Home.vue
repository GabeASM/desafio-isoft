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
                <input type="number" class="form-control" id="numAutos" aria-describedby="emailHelp">
            </div>

            <div>
                <button type="button" class="btn btn-success mt-3">Generar</button>
            </div>
        </div>

        <div class="contenedor input-group mb-3">
            <div class="mb-2">
                <h2>Buscar por:</h2>
            </div>

            <div class="mb-3 fila">
                <label class="input-group-text" for="filtros">Filtros</label>
                <select class="form-select" id="filtros">
                    <option selected>Seleccionar...</option>
                    <option value="1">Filtro1</option>
                    <option value="2">Filtro2</option>
                    <option value="3">Filtro3</option>
                </select>
            </div>
            
            <div class="mb-3">
                <button type="button" class="btn btn-success">Buscar</button>
            </div>
            
        </div>

        <div class="contenedor">
            <div class="mb-2">
                <h2>Ver características de un auto</h2>
            </div>
            
            <div class="mb-3 fila">
                <label class="input-group-text" for="autos">Auto</label>
                <select class="form-select" id="autos">
                    <option selected>Seleccionar...</option>
                    <option value="1">Auto1</option>
                    <option value="2">Auto2</option>
                    <option value="3">Auto3</option>
                </select>
            </div>
            
            <div>
                <button type="button" class="btn btn-success">Ver</button>
            </div>
        </div>
    </body>
    </html>
</template>

<script>
export default {
    name: "HomePage",
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