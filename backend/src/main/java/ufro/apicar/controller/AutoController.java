package ufro.apicar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ufro.apicar.services.IAutoService;

@RestController
public class AutoController {

    @Autowired
    private IAutoService autoService;

    @GetMapping(value = "/generarAutos/{cantidad}")
    public ResponseEntity<?> listarAutos(@PathVariable int cantidad) {

        if (cantidad > 0 & cantidad < 301) {
            autoService.vaciarLista();
            var lista = autoService.listarAutos(cantidad);

            return ResponseEntity.ok().body(lista);
        }
        return ResponseEntity.badRequest().body("Cantidad de autos debe ser un numero valido o no mayor 300 ");
    }

    @GetMapping(value = "/filtro/{precioFiltro}")
    public ResponseEntity<?> filtrarPorPrecio(@PathVariable int precioFiltro) {
        if (precioFiltro < 0)
            return ResponseEntity.badRequest().body("El filtro debe ser valido");

        return ResponseEntity.ok().body(autoService.filtrarAuto(precioFiltro));
    }

    @GetMapping(value = "/detalle/{id}")
    public ResponseEntity<?> verDetalleAuto(@PathVariable int id) {
        return ResponseEntity.ok().body(autoService.buscarPorId(id));
    }

}
