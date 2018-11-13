package persistencia;
// Generated 13-nov-2018 9:21:38 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Sucursales generated by hbm2java
 */
public class Sucursales  implements java.io.Serializable {


     private Integer idSucursal;
     private Empresas empresas;
     private String nombreSucursal;
     private String direccionSucursal;
     private String telefono;
     private Set salases = new HashSet(0);
     private Set precioses = new HashSet(0);

    public Sucursales() {
    }

	
    public Sucursales(Empresas empresas) {
        this.empresas = empresas;
    }
    public Sucursales(Empresas empresas, String nombreSucursal, String direccionSucursal, String telefono, Set salases, Set precioses) {
       this.empresas = empresas;
       this.nombreSucursal = nombreSucursal;
       this.direccionSucursal = direccionSucursal;
       this.telefono = telefono;
       this.salases = salases;
       this.precioses = precioses;
    }
   
    public Integer getIdSucursal() {
        return this.idSucursal;
    }
    
    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }
    public Empresas getEmpresas() {
        return this.empresas;
    }
    
    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }
    public String getNombreSucursal() {
        return this.nombreSucursal;
    }
    
    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }
    public String getDireccionSucursal() {
        return this.direccionSucursal;
    }
    
    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Set getSalases() {
        return this.salases;
    }
    
    public void setSalases(Set salases) {
        this.salases = salases;
    }
    public Set getPrecioses() {
        return this.precioses;
    }
    
    public void setPrecioses(Set precioses) {
        this.precioses = precioses;
    }




}


