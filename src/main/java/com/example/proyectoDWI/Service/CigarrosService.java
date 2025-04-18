package com.example.proyectoDWI.Service;

import com.example.proyectoDWI.Model.Cigarros;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CigarrosService {

    private List<Cigarros> listaCigarros = new ArrayList<>();
    private Long nextId = 1L;

    public List<Cigarros> obtenerTodos() {
        return listaCigarros;
    }

    public Optional<Cigarros> obtenerPorId(Long id) {
        return listaCigarros.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public List<Cigarros> obtenerPorSabor(String sabor) {
        return listaCigarros.stream()
                .filter(c -> c.getSabor().toLowerCase().contains(sabor.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Cigarros guardar(Cigarros cigarro) {
        cigarro.setId(nextId++);
        listaCigarros.add(cigarro);
        return cigarro;
    }

    public boolean eliminar(Long id) {
        return listaCigarros.removeIf(c -> c.getId().equals(id));
    }

    public void actualizar(Long id, Cigarros cigarroActualizado) {
        obtenerPorId(id).ifPresent(c -> {
            c.setSabor(cigarroActualizado.getSabor());
            c.setMarca(cigarroActualizado.getMarca());
            c.setPrecio(cigarroActualizado.getPrecio());
            c.setStock(cigarroActualizado.getStock());
        });
    }
}
