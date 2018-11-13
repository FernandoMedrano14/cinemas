package persistencia;
// Generated 13-nov-2018 9:21:38 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Peliculas generated by hbm2java
 */
public class Peliculas  implements java.io.Serializable {


     private Integer idPelicula;
     private Empresas empresas;
     private Generos generos;
     private String titulo;
     private String duracion;
     private String actores;
     private String directores;
     private String sinopsis;
     private String imagen;
     private String estado;
     private Set funcioneses = new HashSet(0);

    public Peliculas() {
    }

	
    public Peliculas(Empresas empresas, Generos generos, String estado) {
        this.empresas = empresas;
        this.generos = generos;
        this.estado = estado;
    }
    public Peliculas(Empresas empresas, Generos generos, String titulo, String duracion, String actores, String directores, String sinopsis, String imagen, String estado, Set funcioneses) {
       this.empresas = empresas;
       this.generos = generos;
       this.titulo = titulo;
       this.duracion = duracion;
       this.actores = actores;
       this.directores = directores;
       this.sinopsis = sinopsis;
       this.imagen = imagen;
       this.estado = estado;
       this.funcioneses = funcioneses;
    }
   
    public Integer getIdPelicula() {
        return this.idPelicula;
    }
    
    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }
    public Empresas getEmpresas() {
        return this.empresas;
    }
    
    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }
    public Generos getGeneros() {
        return this.generos;
    }
    
    public void setGeneros(Generos generos) {
        this.generos = generos;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDuracion() {
        return this.duracion;
    }
    
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    public String getActores() {
        return this.actores;
    }
    
    public void setActores(String actores) {
        this.actores = actores;
    }
    public String getDirectores() {
        return this.directores;
    }
    
    public void setDirectores(String directores) {
        this.directores = directores;
    }
    public String getSinopsis() {
        return this.sinopsis;
    }
    
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set getFuncioneses() {
        return this.funcioneses;
    }
    
    public void setFuncioneses(Set funcioneses) {
        this.funcioneses = funcioneses;
    }




}


