/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actionform;

import Persistencia.Horarios;
import Persistencia.Salas;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author jose.melendezusam
 */
public class HorariosActionForm extends org.apache.struts.action.ActionForm {
    
    private Integer idHorario;
    private Integer idSala;
    private Salas salas;
    private String horario;
    private String action;
    private String error;
    private List<Horarios> listaHorario;
    private List<Salas> listaSala;

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdSala() {
        return idSala;
    }

    public Salas getSalas() {
        return salas;
    }

    public void setSalas(Salas salas) {
        this.salas = salas;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Horarios> getListaHorario() {
        return listaHorario;
    }

    public void setListaHorario(List<Horarios> listaHorario) {
        this.listaHorario = listaHorario;
    }

    public List<Salas> getListaSala() {
        return listaSala;
    }

    public void setListaSala(List<Salas> listaSala) {
        this.listaSala = listaSala;
    }
    
}
