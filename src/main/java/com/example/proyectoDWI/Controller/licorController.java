package com.example.proyectoDWI.Controller;

import com.example.proyectoDWI.Model.Licor;
import com.example.proyectoDWI.Service.LicorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licores")
public class licorController {

    @Autowired
    private LicorService licorService;

    @GetMapping
    public List<Licor> getAllLicor() {
        return licorService.getAllLicores();
    }

    @PostMapping
    public String addLicor(@RequestBody Licor nuevoLicor) {
        return licorService.addLicor(nuevoLicor);
    }

    @DeleteMapping("/{nombre}")
    public String deleteLicor(@PathVariable String nombre) {
        return licorService.deleteLicor(nombre);
    }

    @PutMapping("/{nombre}")
    public String updateLicor(@PathVariable String nombre, @RequestBody Licor licorActualizado) {
        return licorService.updateLicor(nombre, licorActualizado);
    }
}
