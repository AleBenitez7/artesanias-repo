package com.example.demo.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artesanias")
public class Artesania {
    private long id;
    private String tipo;
    private String nombre;
    private String color;
    private BigDecimal precio;

    public Artesania(){

    }
    public Artesania(String tipo, String nombre, String color, BigDecimal precio)
    {
        this.tipo = tipo;
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

    @Column(name = "tipo", nullable = false)
	public String getTipo() {
		return tipo;
	}
    public void setTipo(String tipo) {
		this.tipo = tipo;
	}

    @Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}
    public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    @Column(name = "color", nullable = false)
	public String getColor() {
		return color;
	}
    public void setColor(String color) {
		this.color = color;
	}

    @Column(name = "precio", nullable = false)
	public BigDecimal getPrecio() {
		return precio;
	}
    public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

    @Override
	public String toString() {
		return "Artesania [id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", color=" + color +"precio="+precio
				+ "]";
	}
    public String save(Artesania artesania) {
        return null;
    }

}
