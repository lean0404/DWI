package com.example.proyectoDWI.Controller;

import com.example.proyectoDWI.Model.VentaRequest;
import com.example.proyectoDWI.Service.VentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public ResponseEntity<String> realizarVenta(@RequestBody VentaRequest request) {
        String mensaje = ventaService.realizarVenta(request);
        if (mensaje.contains("El licor") || mensaje.contains("El cigarro")) {
            return ResponseEntity.badRequest().body(mensaje);
        }
        return ResponseEntity.ok(mensaje);
    }
}
