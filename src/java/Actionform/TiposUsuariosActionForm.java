/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actionform;

import Persistencia.TiposUsuarios;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author jose.melendezusam
 */
public class TiposUsuariosActionForm extends org.apache.struts.action.ActionForm {
    
    private Integer idTipoUsuario;
    private String tipo;
    private String action;
    private String error;
    private List<TiposUsuarios> listaTipoUsuario;

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public List<TiposUsuarios> getListaTipoUsuario() {
        return listaTipoUsuario;
    }

    public void setListaTipoUsuario(List<TiposUsuarios> listaTipoUsuario) {
        this.listaTipoUsuario = listaTipoUsuario;
    }
    
}
