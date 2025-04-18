package com.example.proyectoDWI.Service;

import com.example.proyectoDWI.Model.Licor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LicorServiceTest {

    private LicorService licorService;

    @BeforeEach
    public void setUp() {
        // Configura el servicio antes de cada prueba
        licorService = new LicorService();
    }

    @Test
    public void testGuardarLicor() {
        Licor licor = new Licor("Whiskey", "Licor fuerte", 25.50, 10);
        Licor licorGuardado = licorService.guardar(licor);

        assertNotNull(licorGuardado);
        assertEquals("Whiskey", licorGuardado.getNombre());
        assertEquals(25.50, licorGuardado.getPrecio());
    }

    @Test
    public void testObtenerPorId() {
        Licor licor = new Licor("Vodka", "Licor fuerte", 15.00, 15);
        Licor licorGuardado = licorService.guardar(licor);

        Licor licorEncontrado = licorService.obtenerPorId(licorGuardado.getId()).orElse(null);

        assertNotNull(licorEncontrado);
        assertEquals(licorGuardado.getId(), licorEncontrado.getId());
    }

    @Test
    public void testEliminarLicor() {
        Licor licor = new Licor("Tequila", "Licor fuerte", 20.00, 8);
        Licor licorGuardado = licorService.guardar(licor);

        boolean eliminado = licorService.eliminar(licorGuardado.getId());

        assertTrue(eliminado);
        assertFalse(licorService.obtenerPorId(licorGuardado.getId()).isPresent());
    }

    @Test
    public void testActualizarLicor() {
        Licor licor = new Licor("Rum", "Licor suave", 18.00, 20);
        Licor licorGuardado = licorService.guardar(licor);

        Licor licorActualizado = new Licor("Rum", "Licor suave", 22.00, 18);
        licorService.actualizar(licorGuardado.getId(), licorActualizado);

        Licor licorResultado = licorService.obtenerPorId(licorGuardado.getId()).orElse(null);

        assertNotNull(licorResultado);
        assertEquals(22.00, licorResultado.getPrecio());
        assertEquals(18, licorResultado.getStock());
    }
}
