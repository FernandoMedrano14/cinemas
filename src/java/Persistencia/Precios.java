package Persistencia;
// Generated 11-21-2018 02:24:54 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Precios generated by hbm2java
 */
public class Precios  implements java.io.Serializable {


     private Integer idPrecio;
     private Sucursales sucursales;
     private Double precio;
     private String descripcion;
     private Set funcioneses = new HashSet(0);

    public Precios() {
    }

	
    public Precios(Sucursales sucursales) {
        this.sucursales = sucursales;
    }
    public Precios(Sucursales sucursales, Double precio, String descripcion, Set funcioneses) {
       this.sucursales = sucursales;
       this.precio = precio;
       this.descripcion = descripcion;
       this.funcioneses = funcioneses;
    }
   
    public Integer getIdPrecio() {
        return this.idPrecio;
    }
    
    public void setIdPrecio(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }
    public Sucursales getSucursales() {
        return this.sucursales;
    }
    
    public void setSucursales(Sucursales sucursales) {
        this.sucursales = sucursales;
    }
    public Double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getFuncioneses() {
        return this.funcioneses;
    }
    
    public void setFuncioneses(Set funcioneses) {
        this.funcioneses = funcioneses;
    }




}


