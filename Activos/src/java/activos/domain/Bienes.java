package activos.domain;
// Generated 17/03/2019 06:21:43 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Bienes generated by hbm2java
 */
public class Bienes  implements java.io.Serializable {


     private Integer idBienes;
     private String descripcion;
     private String marca;
     private String modelo;
     private int precio;
     private int cantidad;

    public Bienes() {
    }

	
    public Bienes(String marca, String modelo, int precio, int cantidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
    }
   
    public Integer getIdBienes() {
        return this.idBienes;
    }
    
    public void setIdBienes(Integer idBienes) {
        this.idBienes = idBienes;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}


