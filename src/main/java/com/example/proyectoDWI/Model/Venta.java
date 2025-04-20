package com.example.proyectoDWI.Model;

import java.util.List;

public class Venta {
    private Cliente cliente;
    private List<Licor> licoresComprados;
    private List<Cigarros> cigarrosComprados;
    private double total;

    public Venta() {}

    public Venta(Cliente cliente, List<Licor> licoresComprados, List<Cigarros> cigarrosComprados) {
        this.cliente = cliente;
        this.licoresComprados = licoresComprados;
        this.cigarrosComprados = cigarrosComprados;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        double total = 0.0;
        if (licoresComprados != null) {
            total += licoresComprados.stream().mapToDouble(Licor::getPrecio).sum();
        }
        if (cigarrosComprados != null) {
            total += cigarrosComprados.stream().mapToDouble(Cigarros::getPrecio).sum();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Licor> getLicoresComprados() {
        return licoresComprados;
    }

    public List<Cigarros> getCigarrosComprados() {
        return cigarrosComprados;
    }

    public double getTotal() {
        return total;
    }
}
