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
    public ResponseEntity<?> listarAutos(@PathVariable int cantidad){
        if(autoService.retornarCantidadLista() > 300) return ResponseEntity.ok(autoService.retornarLista());
        return ResponseEntity.ok(autoService.listarAutos(cantidad));
    }

}
