package ufro.apicar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {
    
    @GetMapping("/hola")
    public ResponseEntity<?> hola(){
        return ResponseEntity.ok().body("hola mundo");

    }
}
