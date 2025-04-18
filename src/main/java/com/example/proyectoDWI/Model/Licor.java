package com.example.proyectoDWI.Model;

public class Licor {

    private Long id;
    private String nombre;
    private String tipo;  // Añadido tipo
    private double precio;
    private int stock;

    public Licor() {}

    public Licor(Long id, String nombre, String tipo, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
    }
    // Constructor sin el id (para los casos donde el id se asigna automáticamente)
    public Licor(String nombre, String tipo, double precio, int stock) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }  // Getter para tipo

    public void setTipo(String tipo) { this.tipo = tipo; }  // Setter para tipo

    public double getPrecio() { return precio; }

    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }
}
