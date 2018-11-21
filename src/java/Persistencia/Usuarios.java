package Persistencia;
// Generated 11-21-2018 02:24:54 PM by Hibernate Tools 4.3.1



/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private Integer idUsuario;
     private Empresas empresas;
     private TiposUsuarios tiposUsuarios;
     private String nickname;
     private String nombres;
     private String apellidos;
     private String correo;
     private String contrasenia;

    public Usuarios() {
    }

	
    public Usuarios(Empresas empresas, TiposUsuarios tiposUsuarios) {
        this.empresas = empresas;
        this.tiposUsuarios = tiposUsuarios;
    }
    public Usuarios(Empresas empresas, TiposUsuarios tiposUsuarios, String nickname, String nombres, String apellidos, String correo, String contrasenia) {
       this.empresas = empresas;
       this.tiposUsuarios = tiposUsuarios;
       this.nickname = nickname;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.correo = correo;
       this.contrasenia = contrasenia;
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Empresas getEmpresas() {
        return this.empresas;
    }
    
    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }
    public TiposUsuarios getTiposUsuarios() {
        return this.tiposUsuarios;
    }
    
    public void setTiposUsuarios(TiposUsuarios tiposUsuarios) {
        this.tiposUsuarios = tiposUsuarios;
    }
    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasenia() {
        return this.contrasenia;
    }
    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }




}


