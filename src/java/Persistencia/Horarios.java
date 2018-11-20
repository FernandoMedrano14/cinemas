package Persistencia;
// Generated 11-14-2018 10:47:01 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Horarios generated by hbm2java
 */
public class Horarios  implements java.io.Serializable {


     private Integer idHorario;
     private Integer idSala;
     private String horario;
     private Set funcioneses = new HashSet(0);

    public Horarios() {
    }

	
    public Horarios(Integer idSala, String horario) {
        this.idSala = idSala;
        this.horario = horario;
    }
    public Horarios(Integer idSala, String horario, Set funcioneses) {
       this.idSala = idSala;
       this.horario = horario;
       this.funcioneses = funcioneses;
    }
   
    public Integer getIdHorario() {
        return this.idHorario;
    }
    
    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }
    
    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }
    public String getHorario() {
        return this.horario;
    }
    
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public Set getFuncioneses() {
        return this.funcioneses;
    }
    
    public void setFuncioneses(Set funcioneses) {
        this.funcioneses = funcioneses;
    }




}


