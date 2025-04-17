package com.example.proyectoDWI.Service;

import com.example.proyectoDWI.Model.Cigarros;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CigarrosService {

    private List<Cigarros> listaCigarros = new ArrayList<>();
    private Long contadorId = 1L;

    public List<Cigarros> obtenerTodos() {
        return listaCigarros;
    }

    public Optional<Cigarros> obtenerPorId(Long id) {
        return listaCigarros.stream()
                .filter(cigarro -> cigarro.getId().equals(id))
                .findFirst();
    }

    public Cigarros crearCigarro(Cigarros cigarro) {
        cigarro.setId(contadorId++);
        listaCigarros.add(cigarro);
        return cigarro;
    }

    public boolean actualizarCigarro(Long id, Cigarros nuevoCigarro) {
        for (int i = 0; i < listaCigarros.size(); i++) {
            if (listaCigarros.get(i).getId().equals(id)) {
                nuevoCigarro.setId(id);
                listaCigarros.set(i, nuevoCigarro);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarParcialmente(Long id, Cigarros parcial) {
        for (Cigarros cigarro : listaCigarros) {
            if (cigarro.getId().equals(id)) {
                if (parcial.getNombre() != null) cigarro.setNombre(parcial.getNombre());
                if (parcial.getSabor() != null) cigarro.setSabor(parcial.getSabor());
                if (parcial.getPrecio() != 0) cigarro.setPrecio(parcial.getPrecio());
                if (parcial.getStock() != 0) cigarro.setStock(parcial.getStock());
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCigarro(Long id) {
        return listaCigarros.removeIf(cigarro -> cigarro.getId().equals(id));
    }

    public Optional<Cigarros> buscarPorNombre(String nombre) {
        return listaCigarros.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

}
