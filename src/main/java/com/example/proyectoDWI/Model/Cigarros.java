package com.example.proyectoDWI.Model;

public class Cigarros {

    private String nombre;
    private String sabor;
    private double precio;
    private int stock;

    public Cigarros(){}

    public Cigarros(String nombre,String sabor, double precio, int stock) {
        this.nombre = nombre;
        this.sabor= sabor;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
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
}
