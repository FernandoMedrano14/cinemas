
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actionform;

import Persistencia.Funciones;
import Persistencia.Horarios;
import Persistencia.Peliculas;
import Persistencia.Precios;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author jose.melendezusam
 */
public class FuncionesActionForm extends org.apache.struts.action.ActionForm {
 
    private Integer idFuncion;
    private Integer idHorario;
    private Integer idPelicula;
    private Integer idPrecio;
    private String estado;
    private String action;
    private String error;
    private List<Funciones> listaFunciones;
    private List<Horarios> listaHorario;
    private List<Peliculas> listaPeliculas;
    private List<Precios> listaPrecio;

    public Integer getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Integer idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Integer getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public List<Funciones> getListaFunciones() {
        return listaFunciones;
    }

    public void setListaFunciones(List<Funciones> listaFunciones) {
        this.listaFunciones = listaFunciones;
    }

    public List<Horarios> getListaHorario() {
        return listaHorario;
    }

    public void setListaHorario(List<Horarios> listaHorario) {
        this.listaHorario = listaHorario;
    }

    public List<Peliculas> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(List<Peliculas> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public List<Precios> getListaPrecio() {
        return listaPrecio;
    }

    public void setListaPrecio(List<Precios> listaPrecio) {
        this.listaPrecio = listaPrecio;
    }
    
}
