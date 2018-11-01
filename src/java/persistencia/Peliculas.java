package persistencia;
// Generated 11-01-2018 02:48:26 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Peliculas generated by hbm2java
 */
public class Peliculas  implements java.io.Serializable {


     private int idPelicula;
     private Clasificaciones clasificaciones;
     private Generos generos;
     private String nombre;
     private String sinopsis;
     private String duracion;
     private Set ticketses = new HashSet(0);

    public Peliculas() {
    }

	
    public Peliculas(int idPelicula, Clasificaciones clasificaciones, Generos generos, String nombre, String sinopsis, String duracion) {
        this.idPelicula = idPelicula;
        this.clasificaciones = clasificaciones;
        this.generos = generos;
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.duracion = duracion;
    }
    public Peliculas(int idPelicula, Clasificaciones clasificaciones, Generos generos, String nombre, String sinopsis, String duracion, Set ticketses) {
       this.idPelicula = idPelicula;
       this.clasificaciones = clasificaciones;
       this.generos = generos;
       this.nombre = nombre;
       this.sinopsis = sinopsis;
       this.duracion = duracion;
       this.ticketses = ticketses;
    }
   
    public int getIdPelicula() {
        return this.idPelicula;
    }
    
    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }
    public Clasificaciones getClasificaciones() {
        return this.clasificaciones;
    }
    
    public void setClasificaciones(Clasificaciones clasificaciones) {
        this.clasificaciones = clasificaciones;
    }
    public Generos getGeneros() {
        return this.generos;
    }
    
    public void setGeneros(Generos generos) {
        this.generos = generos;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getSinopsis() {
        return this.sinopsis;
    }
    
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getDuracion() {
        return this.duracion;
    }
    
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    public Set getTicketses() {
        return this.ticketses;
    }
    
    public void setTicketses(Set ticketses) {
        this.ticketses = ticketses;
    }




}


