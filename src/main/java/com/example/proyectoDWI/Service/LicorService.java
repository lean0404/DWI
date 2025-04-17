package com.example.proyectoDWI.Service;

import com.example.proyectoDWI.Model.Licor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LicorService {

    private List<Licor> listaLicores = new ArrayList<>();
    private Long nextId = 1L;

    public List<Licor> obtenerTodos() {
        return listaLicores;
    }

    public Optional<Licor> obtenerPorId(Long id) {
        return listaLicores.stream().filter(l -> l.getId().equals(id)).findFirst();
    }

    public List<Licor> obtenerPorTipo(String tipo) {
        return listaLicores.stream()
                .filter(l -> l.getTipo().toLowerCase().contains(tipo.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Licor guardar(Licor licor) {
        licor.setId(nextId++);
        listaLicores.add(licor);
        return licor;
    }

    public boolean eliminar(Long id) {
        return listaLicores.removeIf(l -> l.getId().equals(id));
    }

    public void actualizar(Long id, Licor licorActualizado) {
        obtenerPorId(id).ifPresent(licor -> {
            licor.setNombre(licorActualizado.getNombre());
            licor.setTipo(licorActualizado.getTipo());
            licor.setPrecio(licorActualizado.getPrecio());
            licor.setStock(licorActualizado.getStock());
        });
    }
}
