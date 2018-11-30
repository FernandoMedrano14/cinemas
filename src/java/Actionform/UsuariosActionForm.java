/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actionform;

import Persistencia.Empresas;
import Persistencia.TiposUsuarios;
import Persistencia.Usuarios;
import java.util.List;

/**
 *
 * @author jose.melendezusam
 */
public class UsuariosActionForm extends org.apache.struts.action.ActionForm {
    
    private Integer idUsuario;
    private Integer idTipoUsuario;
    private Integer idEmpresa;
    private String nickname;
    private String nombres;
    private String apellidos;
    private String correo;
    private String contrasenia;
    private String action;
    private String error;
    private List<Usuarios> listaUsuario;
    private List<TiposUsuarios> listaTiposUsuarios;
    private List<Empresas> listaEmpresas;

    public List<TiposUsuarios> getListaTiposUsuarios() {
        return listaTiposUsuarios;
    }

    public void setListaTiposUsuarios(List<TiposUsuarios> listaTiposUsuarios) {
        this.listaTiposUsuarios = listaTiposUsuarios;
    }
    
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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

    public List<Usuarios> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuarios> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public List<Empresas> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<Empresas> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }
    
}
