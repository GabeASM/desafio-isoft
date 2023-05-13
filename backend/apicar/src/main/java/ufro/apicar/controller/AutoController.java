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

    @GetMapping("/{cantidad}")
    public ResponseEntity<?> listarAutos(@PathVariable String cantidad){
        try{
            return getResponseEntityAutos(cantidad);
        }catch (NumberFormatException e){
            return ResponseEntity.badRequest().body("La cantidad debe ser un numero valido");
        }
    }

    private ResponseEntity<?> getResponseEntityAutos(String cantidad) {
        Integer cantidadInt = Integer.parseInt(cantidad);
        ResponseEntity<?> body = validarCantidad(cantidadInt);
        if (body != null) return body;
        return ResponseEntity.ok(autoService.listarAutos(cantidadInt));
    }

    private ResponseEntity<?> validarCantidad(Integer cantidadInt) {
        if(cantidadInt < 0 ) return ResponseEntity.badRequest().body("La cantidad debe ser un numero valido");
        if(autoService.retornarCantidadLista() > 300) return ResponseEntity.ok(autoService.retornarLista());
        if(cantidadInt > 300 ) return ResponseEntity.badRequest().body("Cantidad de autos no puede ser mayor a 300");
        return null;
    }

}
