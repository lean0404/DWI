package com.example.proyectoDWI.Service;

import com.example.proyectoDWI.Model.Licor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LicorService {

    private List<Licor> licorList = new ArrayList<>();

    public LicorService() {
        licorList.add(new Licor("Smirnoff", 25.5, 100));
        licorList.add(new Licor("Rus Kalla", 18.0, 50));
    }

    public List<Licor> getAllLicores() {
        return licorList;
    }

    public String addLicor(Licor nuevoLicor) {
        licorList.add(nuevoLicor);
        return "Licor agregado: " + nuevoLicor.getNombre();
    }

    public String deleteLicor(String nombre) {
        for (Licor licor : licorList) {
            if (licor.getNombre().equalsIgnoreCase(nombre)) {
                licorList.remove(licor);
                return "Licor eliminado: " + nombre;
            }
        }
        return "Licor no encontrado";
    }

    public String updateLicor(String nombre, Licor licorActualizado) {
        for (Licor licor : licorList) {
            if (licor.getNombre().equalsIgnoreCase(nombre)) {
                licor.setPrecio(licorActualizado.getPrecio());
                licor.setStock(licorActualizado.getStock());
                return "Licor actualizado: " + nombre;
            }
        }
        return "Licor no encontrado";
    }
}
