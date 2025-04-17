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
    public ResponseEntity<Licor> obtenerPorId(@PathVariable Long id) {
        return licorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/{tipo}")
    public List<Licor> obtenerPorTipo(@PathVariable String tipo) {
        return licorService.obtenerPorTipo(tipo);
    }

    @PostMapping
    public Licor crear(@RequestBody Licor licor) {
        return licorService.guardar(licor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable Long id, @RequestBody Licor licor) {
        if (licorService.obtenerPorId(id).isPresent()) {
            licorService.actualizar(id, licor);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (licorService.eliminar(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
