package persistencia;
// Generated 13-nov-2018 9:21:38 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Empresas generated by hbm2java
 */
public class Empresas  implements java.io.Serializable {


     private Integer idEmpresa;
     private String nombre;
     private String direccion;
     private String telefono;
     private String nit;
     private String numeroRegistro;
     private String giro;
     private Set sucursaleses = new HashSet(0);
     private Set peliculases = new HashSet(0);
     private Set usuarioses = new HashSet(0);

    public Empresas() {
    }

    public Empresas(String nombre, String direccion, String telefono, String nit, String numeroRegistro, String giro, Set sucursaleses, Set peliculases, Set usuarioses) {
       this.nombre = nombre;
       this.direccion = direccion;
       this.telefono = telefono;
       this.nit = nit;
       this.numeroRegistro = numeroRegistro;
       this.giro = giro;
       this.sucursaleses = sucursaleses;
       this.peliculases = peliculases;
       this.usuarioses = usuarioses;
    }
   
    public Integer getIdEmpresa() {
        return this.idEmpresa;
    }
    
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getNit() {
        return this.nit;
    }
    
    public void setNit(String nit) {
        this.nit = nit;
    }
    public String getNumeroRegistro() {
        return this.numeroRegistro;
    }
    
    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }
    public String getGiro() {
        return this.giro;
    }
    
    public void setGiro(String giro) {
        this.giro = giro;
    }
    public Set getSucursaleses() {
        return this.sucursaleses;
    }
    
    public void setSucursaleses(Set sucursaleses) {
        this.sucursaleses = sucursaleses;
    }
    public Set getPeliculases() {
        return this.peliculases;
    }
    
    public void setPeliculases(Set peliculases) {
        this.peliculases = peliculases;
    }
    public Set getUsuarioses() {
        return this.usuarioses;
    }
    
    public void setUsuarioses(Set usuarioses) {
        this.usuarioses = usuarioses;
    }




}


