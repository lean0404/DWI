package com.example.proyectoDWI.Controller;

import com.example.proyectoDWI.Model.Cigarros;
import com.example.proyectoDWI.Service.CigarrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cigarros")
public class cigarrosController {

    @Autowired
    private CigarrosService cigarroService;

    @GetMapping
    public List<Cigarros> obtenerTodos() {
        return cigarroService.obtenerTodos();
    }

    /*Reciba una lista*/
    @PostMapping("/lista")
    public ResponseEntity<List<Cigarros>> crearLista(@RequestBody List<Cigarros> cigarros) {
        List<Cigarros> creados = new ArrayList<>();
        for (Cigarros c : cigarros) {
            creados.add(cigarroService.crearCigarro(c));
        }
        return ResponseEntity.ok(creados);
    }

    /*Buscar por ID*/
    @GetMapping("/{id}")
    public ResponseEntity<Cigarros> obtenerPorId(@PathVariable Long id) {
        return cigarroService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /*Buscar por nombre*/
    @GetMapping("/buscar")
    public ResponseEntity<Cigarros> buscarPorNombre(@RequestParam String nombre) {
        return cigarroService.buscarPorNombre(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body(null));
    }


    @PostMapping
    public Cigarros crearCigarro(@RequestBody Cigarros cigarro) {
        return cigarroService.crearCigarro(cigarro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarCigarro(@PathVariable Long id, @RequestBody Cigarros nuevoCigarro) {
        boolean actualizado = cigarroService.actualizarCigarro(id, nuevoCigarro);
        if (actualizado) {
            return ResponseEntity.ok("Cigarro actualizado correctamente con ID: " + id);
        }
        return ResponseEntity.status(404).body("Cigarro no encontrado con ID: " + id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> actualizarParcialmente(@PathVariable Long id, @RequestBody Cigarros parcial) {
        boolean actualizado = cigarroService.actualizarParcialmente(id, parcial);
        if (actualizado) {
            return ResponseEntity.ok("Cigarro actualizado parcialmente con ID: " + id);
        }
        return ResponseEntity.status(404).body("Cigarro no encontrado con ID: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCigarro(@PathVariable Long id) {
        boolean eliminado = cigarroService.eliminarCigarro(id);
        if (eliminado) {
            return ResponseEntity.ok("Cigarro eliminado correctamente con ID: " + id);
        }
        return ResponseEntity.status(404).body("No se encontró el cigarro con ID: " + id);
    }
}
