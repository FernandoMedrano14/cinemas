/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actionform;

import Persistencia.Clasificaciones;
import java.util.List;

/**
 *
 * @author david.floresusam
 */
public class ClasificacionesActionForm extends org.apache.struts.action.ActionForm {

    private int idClasificacion;
    private String tipoClasificacion;
    private String detalleClasificacion;
    private String action;
    private String error;
    private List<Clasificaciones> listaClasificacion;

    public int getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getTipoClasificacion() {
        return tipoClasificacion;
    }

    public void setTipoClasificacion(String tipoClasificacion) {
        this.tipoClasificacion = tipoClasificacion;
    }

    public String getDetalleClasificacion() {
        return detalleClasificacion;
    }

    public void setDetalleClasificacion(String detalleClasificacion) {
        this.detalleClasificacion = detalleClasificacion;
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

    public List<Clasificaciones> getListaClasificacion() {
        return listaClasificacion;
    }

    public void setListaClasificacion(List<Clasificaciones> listaClasificacion) {
        this.listaClasificacion = listaClasificacion;
    }

}
