package com.example.proyectoDWI.Controller;


import com.example.proyectoDWI.Model.Cigarros;
import com.example.proyectoDWI.Service.CigarrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cigarro")
public class cigarroController {

    @Autowired
    private CigarrosService cigarrosService;

    @GetMapping
    public List<Cigarros> getAllCigarros(){
        return CigarrosService.getAllCigarros();
    }

    @PostMapping
    public String addCigarros(@RequestBody Cigarros nuecigarro){
        return CigarrosService.addCigarros(nuecigarro);
    }

    @DeleteMapping
    public String deleteCigarros(@PathVariable String nombre){
        return CigarrosService.deteleCigarros(nombre);
    }

    @PutMapping("/{nombre}")
    public String updateCigarros(@PathVariable String nombre, @RequestBody Cigarros cigarroActualizado){
        return CigarrosService.updateCigarro(nombre, cigarroActualizado);
    }
}
