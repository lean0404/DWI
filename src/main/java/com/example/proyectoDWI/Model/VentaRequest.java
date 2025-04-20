package com.example.proyectoDWI.Model;

import java.util.List;

public class VentaRequest {
    private Cliente cliente;
    private List<Long> idsLicores;
    private List<Long> idsCigarros;

    public VentaRequest() {}

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Long> getIdsLicores() {
        return idsLicores;
    }

    public void setIdsLicores(List<Long> idsLicores) {
        this.idsLicores = idsLicores;
    }

    public List<Long> getIdsCigarros() {
        return idsCigarros;
    }

    public void setIdsCigarros(List<Long> idsCigarros) {
        this.idsCigarros = idsCigarros;
    }
}
