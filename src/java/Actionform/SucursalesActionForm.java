/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actionform;

import Persistencia.Sucursales;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author jose.melendezusam
 */
public class SucursalesActionForm extends org.apache.struts.action.ActionForm {
    
    private Integer idSucursal;
    private Integer idEmpresa;
    private String nombreSucursal;
    private String direccionSucursal;
    private String telelfono;
    private String action;
    private String error;
    private List<Sucursales> listaSucursal;

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
    }

    public String getTelelfono() {
        return telelfono;
    }

    public void setTelelfono(String telelfono) {
        this.telelfono = telelfono;
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

    public List<Sucursales> getListaSucursal() {
        return listaSucursal;
    }

    public void setListaSucursal(List<Sucursales> listaSucursal) {
        this.listaSucursal = listaSucursal;
    }
    
}
