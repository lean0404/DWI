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
    public ResponseEntity<?> listarTodos() {
        List<Cigarros> lista = cigarrosService.obtenerTodos();
        if (lista.isEmpty()) {
            return ResponseEntity.status(404).body("No se encontraron cigarros en el sistema");
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        return cigarrosService.obtenerPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("Cigarro no encontrado con ID: " + id));
    }

    @GetMapping("/buscar/{sabor}")
    public ResponseEntity<?> obtenerPorSabor(@PathVariable String sabor) {
        List<Cigarros> resultados = cigarrosService.obtenerPorSabor(sabor);
        if (resultados.isEmpty()) {
            return ResponseEntity.status(404).body("No se encontraron cigarros con sabor: " + sabor);
        }
        return ResponseEntity.ok(resultados);
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Cigarros cigarro) {
        cigarrosService.guardar(cigarro);
        return ResponseEntity.ok("Cigarro añadido correctamente: " +cigarro.getMarca());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Long id, @RequestBody Cigarros cigarro) {
        if (cigarrosService.obtenerPorId(id).isPresent()) {
            cigarrosService.actualizar(id, cigarro);
            return ResponseEntity.ok("Cigarro actualizado correctamente " );
        } else {
            return ResponseEntity.status(404).body("No se encontró el cigarro con ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        if (cigarrosService.eliminar(id)) {
            return ResponseEntity.ok("Cigarro eliminado correctamente");
        } else {
            return ResponseEntity.status(404).body("No se encontró el cigarro con ID: " + id);
        }
    }
}
