/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actionform;

import Persistencia.Funciones;
import Persistencia.Ventas;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author jose.melendezusam
 */
public class VentasActionForm extends org.apache.struts.action.ActionForm {
    
    private Integer idVenta;
    private Integer idFuncion;
    private String fechaVenta;
    private String nombreCliente;
    private Integer cantidad;
    private String dui;
    private Double total;
    private String estado;
    private String action;
    private String error;
    private List<Ventas> listaVenta;
    private List<Funciones> listaFuncion;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Integer idFuncion) {
        this.idFuncion = idFuncion;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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

    public List<Ventas> getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(List<Ventas> listaVenta) {
        this.listaVenta = listaVenta;
    }

    public List<Funciones> getListaFuncion() {
        return listaFuncion;
    }

    public void setListaFuncion(List<Funciones> listaFuncion) {
        this.listaFuncion = listaFuncion;
    }
    
}
