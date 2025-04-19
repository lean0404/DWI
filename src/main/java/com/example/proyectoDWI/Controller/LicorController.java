package com.example.proyectoDWI.Controller;

import com.example.proyectoDWI.Model.Licor;
import com.example.proyectoDWI.Service.LicorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licores")
public class LicorController {

    private final LicorService licorService;

    public LicorController(LicorService licorService) {
        this.licorService = licorService;
    }

    @GetMapping
    public List<Licor> listarTodos() {
        return licorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        return licorService.obtenerPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("Producto no encontrado"));
    }


    @GetMapping("/buscar/{tipo}")
    public ResponseEntity<?> obtenerPorTipo(@PathVariable String tipo) {
        List<Licor> encontrados = licorService.obtenerPorTipo(tipo);
        if (encontrados.isEmpty()) {
            return ResponseEntity.status(404).body("No se encontraron productos del tipo: " + tipo);
        }
        return ResponseEntity.ok(encontrados);
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Licor licor) {
        licorService.guardar(licor);
        return ResponseEntity.ok("Producto añadido correctamente: " + licor.getNombre());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Long id, @RequestBody Licor licor) {
        if (licorService.obtenerPorId(id).isPresent()) {
            licorService.actualizar(id, licor);
            return ResponseEntity.ok("Producto actualizado correctamente");
        } else {
            return ResponseEntity.status(404).body("Producto no encontrado para actualizar");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        if (licorService.eliminar(id)) {
            return ResponseEntity.ok("Producto eliminado correctamente");
        } else {
            return ResponseEntity.status(404).body("Producto no encontrado para eliminar");
        }
    }
}
