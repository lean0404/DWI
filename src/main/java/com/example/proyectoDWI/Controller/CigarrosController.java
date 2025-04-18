package com.example.proyectoDWI.Controller;

import com.example.proyectoDWI.Model.Cigarros;
import com.example.proyectoDWI.Service.CigarrosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cigarros")
public class CigarrosController {

    private final CigarrosService cigarrosService;

    public CigarrosController(CigarrosService cigarrosService) {
        this.cigarrosService = cigarrosService;
    }

    @GetMapping
    public List<Cigarros> listarTodos() {
        return cigarrosService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cigarros> obtenerPorId(@PathVariable Long id) {
        return cigarrosService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/{sabor}")
    public List<Cigarros> obtenerPorSabor(@PathVariable String sabor) {
        return cigarrosService.obtenerPorSabor(sabor);
    }

    @PostMapping
    public Cigarros crear(@RequestBody Cigarros cigarro) {
        return cigarrosService.guardar(cigarro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable Long id, @RequestBody Cigarros cigarro) {
        if (cigarrosService.obtenerPorId(id).isPresent()) {
            cigarrosService.actualizar(id, cigarro);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (cigarrosService.eliminar(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
