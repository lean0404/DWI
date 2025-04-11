package com.example.proyectoDWI.Service;


import com.example.proyectoDWI.Model.Cigarros;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CigarrosService {

    private static List <Cigarros> CigarrosList = new ArrayList<>();

    public CigarrosService(){
        CigarrosList.add(new Cigarros("Laki","uva",11.5,15));
    }

    public static List<Cigarros> getAllCigarros(){
        return CigarrosList;
    }

    public static String addCigarros(Cigarros nuevocigarro){
        CigarrosList.add(nuevocigarro);
        return "Cigarro agregado: " +nuevocigarro.getNombre();
    }

    public static String deteleCigarros(String nombre){
        for (Cigarros cigarro: CigarrosList){
            if (cigarro.getNombre().equalsIgnoreCase(nombre)){
                CigarrosList.remove(cigarro);
                return "Cigarro eliminado " + nombre;
            }
        }
        return "Cigarro no encontrado ";
    }


    public static String updateCigarro(String nombre, Cigarros CigarroActualizado){
        for (Cigarros cigarros : CigarrosList){
            if (cigarros.getNombre().equalsIgnoreCase(nombre)){
                cigarros.setPrecio(CigarroActualizado.getPrecio());
                cigarros.setStock(CigarroActualizado.getStock());
                return "Cigarro actualizado : " + nombre;
            }
        }
        return "Cigarro no encontrado ";
    }

}
