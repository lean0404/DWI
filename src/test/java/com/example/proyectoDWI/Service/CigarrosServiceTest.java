package com.example.proyectoDWI.Service;

import com.example.proyectoDWI.Model.Cigarros;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CigarrosServiceTest {

    private CigarrosService cigarroService;

    @BeforeEach
    public void setUp() {
        cigarroService = new CigarrosService();
    }

    @Test
    public void testGuardarCigarro() {
        Cigarros cigarro = new Cigarros("Mentolado", "Marlboro", 12.50, 100);
        // Guardamos el cigarro
        Cigarros cigarroGuardado = cigarroService.guardar(cigarro);

        // Verificamos que el cigarro guardado no sea null
        assertNotNull(cigarroGuardado);
        assertEquals("Mentolado", cigarroGuardado.getSabor());
        assertEquals("Marlboro", cigarroGuardado.getMarca());
        assertEquals(12.50, cigarroGuardado.getPrecio());
        assertEquals(100, cigarroGuardado.getStock());
    }

    @Test
    public void testObtenerPorId() {
        // Creamos y guardamos un cigarro
        Cigarros cigarro = new Cigarros("Normal", "Davidoff", 15.00, 200);
        Cigarros cigarroGuardado = cigarroService.guardar(cigarro);

        // Obtenemos el cigarro por ID
        Cigarros cigarroEncontrado = cigarroService.obtenerPorId(cigarroGuardado.getId()).orElse(null);

        // Verificamos que el cigarro sea encontrado correctamente
        assertNotNull(cigarroEncontrado);
        assertEquals(cigarroGuardado.getId(), cigarroEncontrado.getId());
    }

    @Test
    public void testEliminarCigarro() {
        // Creamos y guardamos un cigarro
        Cigarros cigarro = new Cigarros("Fino", "Cohiba", 25.00, 50);
        Cigarros cigarroGuardado = cigarroService.guardar(cigarro);

        // Eliminamos el cigarro
        boolean eliminado = cigarroService.eliminar(cigarroGuardado.getId());

        // Verificamos que el cigarro haya sido eliminado
        assertTrue(eliminado);
        assertFalse(cigarroService.obtenerPorId(cigarroGuardado.getId()).isPresent());
    }

    @Test
    public void testActualizarCigarro() {
        // Creamos y guardamos un cigarro
        Cigarros cigarro = new Cigarros("Citrus", "Lucky Strike", 18.00, 30);
        Cigarros cigarroGuardado = cigarroService.guardar(cigarro);

        // Actualizamos el cigarro con nuevos datos
        Cigarros cigarroActualizado = new Cigarros("Fresa", "Lucky Strike", 20.00, 25);
        cigarroService.actualizar(cigarroGuardado.getId(), cigarroActualizado);

        // Obtenemos el cigarro actualizado
        Cigarros cigarroResultado = cigarroService.obtenerPorId(cigarroGuardado.getId()).orElse(null);

        // Verificamos que los datos del cigarro hayan sido actualizados correctamente
        assertNotNull(cigarroResultado);
        assertEquals("Fresa", cigarroResultado.getSabor());
        assertEquals(20.00, cigarroResultado.getPrecio());
        assertEquals(25, cigarroResultado.getStock());
    }
}
