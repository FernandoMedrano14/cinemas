package Persistencia;
// Generated 11-21-2018 02:24:54 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Clasificaciones generated by hbm2java
 */
public class Clasificaciones  implements java.io.Serializable {


     private Integer idClasificacion;
     private String tipoClasificacion;
     private String detalleClasificacion;
     private Set peliculases = new HashSet(0);

    public Clasificaciones() {
    }

	
    public Clasificaciones(String tipoClasificacion, String detalleClasificacion) {
        this.tipoClasificacion = tipoClasificacion;
        this.detalleClasificacion = detalleClasificacion;
    }
    public Clasificaciones(String tipoClasificacion, String detalleClasificacion, Set peliculases) {
       this.tipoClasificacion = tipoClasificacion;
       this.detalleClasificacion = detalleClasificacion;
       this.peliculases = peliculases;
    }
   
    public Integer getIdClasificacion() {
        return this.idClasificacion;
    }
    
    public void setIdClasificacion(Integer idClasificacion) {
        this.idClasificacion = idClasificacion;
    }
    public String getTipoClasificacion() {
        return this.tipoClasificacion;
    }
    
    public void setTipoClasificacion(String tipoClasificacion) {
        this.tipoClasificacion = tipoClasificacion;
    }
    public String getDetalleClasificacion() {
        return this.detalleClasificacion;
    }
    
    public void setDetalleClasificacion(String detalleClasificacion) {
        this.detalleClasificacion = detalleClasificacion;
    }
    public Set getPeliculases() {
        return this.peliculases;
    }
    
    public void setPeliculases(Set peliculases) {
        this.peliculases = peliculases;
    }




}


