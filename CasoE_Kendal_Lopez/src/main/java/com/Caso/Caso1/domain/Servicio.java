package com.Caso.Caso1.domain;


import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(precision = 8, scale = 2) // Usar BigDecimal para precios
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}