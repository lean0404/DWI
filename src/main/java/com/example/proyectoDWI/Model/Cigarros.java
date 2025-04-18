package com.example.proyectoDWI.Model;

public class Cigarros {
    private Long id;
    private String sabor;
    private String marca;
    private double precio;
    private int stock;

    public Cigarros() {}

    public Cigarros(String sabor, String marca, double precio, int stock, long id) {
        this.sabor = sabor;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
