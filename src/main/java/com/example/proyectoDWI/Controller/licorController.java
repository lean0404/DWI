package com.example.proyectoDWI.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/licores")

public class licorController {
    private List<String> licor= new ArrayList<>();
    /*servicio*/

    public licorController(){
        licor.add("Smirnoff");
        licor.add("Rus Kalla");
    }

    @GetMapping
    public List<String> getAllLicor(){
        return licor;
    }
}
