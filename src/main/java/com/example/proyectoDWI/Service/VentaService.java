package com.example.proyectoDWI.Service;

import com.example.proyectoDWI.Model.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    private final LicorService licorService;
    private final CigarrosService cigarrosService;

    public VentaService(LicorService licorService, CigarrosService cigarrosService) {
        this.licorService = licorService;
        this.cigarrosService = cigarrosService;
    }

    public String realizarVenta(VentaRequest request) {
        Cliente cliente = request.getCliente();
        List<Long> idsLicores = request.getIdsLicores();
        List<Long> idsCigarros = request.getIdsCigarros();

        List<Licor> licoresComprados = new ArrayList<>();
        List<Cigarros> cigarrosComprados = new ArrayList<>();

        // Validación y descuento de stock de licores
        if (idsLicores != null) {
            for (Long id : idsLicores) {
                Optional<Licor> licorOpt = licorService.obtenerPorId(id);
                if (licorOpt.isPresent()) {
                    Licor licor = licorOpt.get();
                    if (licor.getStock() > 0) {
                        licor.setStock(licor.getStock() - 1);
                        licorService.actualizar(id, licor);
                        licoresComprados.add(licor);
                    } else {
                        return "El licor con ID " + id + " no tiene stock disponible.";
                    }
                } else {
                    return "Licor con ID " + id + " no encontrado.";
                }
            }
        }

        // Validación y descuento de stock de cigarros
        if (idsCigarros != null) {
            for (Long id : idsCigarros) {
                Optional<Cigarros> cigarroOpt = cigarrosService.obtenerPorId(id);
                if (cigarroOpt.isPresent()) {
                    Cigarros cigarro = cigarroOpt.get();
                    if (cigarro.getStock() > 0) {
                        cigarro.setStock(cigarro.getStock() - 1);
                        cigarrosService.actualizar(id, cigarro);
                        cigarrosComprados.add(cigarro);
                    } else {
                        return "El cigarro con ID " + id + " no tiene stock disponible.";
                    }
                } else {
                    return "Cigarro con ID " + id + " no encontrado.";
                }
            }
        }

        Venta venta = new Venta(cliente, licoresComprados, cigarrosComprados);

        // Generación del mensaje de la venta
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("✅ Venta realizada con éxito.\n");
        mensaje.append("Cliente: ").append(cliente.getNombre()).append(" ").append(cliente.getApellido()).append("\n");

        mensaje.append("Licores comprados:\n");
        if (!licoresComprados.isEmpty()) {
            for (Licor licor : licoresComprados) {
                mensaje.append("- ").append(licor.getNombre()).append(" (S/.").append(licor.getPrecio()).append(")\n");
            }
        } else {
            mensaje.append("- Ninguno\n");
        }

        mensaje.append("Cigarros comprados:\n");
        if (!cigarrosComprados.isEmpty()) {
            for (Cigarros cigarro : cigarrosComprados) {
                mensaje.append("- ").append(cigarro.getMarca()).append(" ").append("(").append(cigarro.getSabor()).append(") $").append(cigarro.getPrecio()).append("\n");
            }
        } else {
            mensaje.append("- Ninguno\n");
        }

        mensaje.append("Total: S/.").append(venta.getTotal());

        return mensaje.toString();
    }
}
